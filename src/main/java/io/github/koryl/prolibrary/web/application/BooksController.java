package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.business.service.BookServiceImpl;
import io.github.koryl.prolibrary.business.service.UserServiceImpl;
import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library/books")
public class BooksController {

    private static Logger logger = LoggerFactory.getLogger(BooksController.class);

    private final BookServiceImpl bookService;
    private final UserServiceImpl userService;

    @Autowired
    public BooksController(BookServiceImpl bookService, UserServiceImpl userService) {

        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String books(Model model) {

        List<Book> allBooksList = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooksList);
        return "books";
    }

    @GetMapping("/{id}")
    public String showSelectedBook(Model model, @PathVariable("id") Long id) {

        model.addAttribute("book", bookService.getByBookId(id));
        return "single-book";
    }

    @PostMapping("/search")
    public String searchBook(Model model, @RequestParam("bookName") String bookName) {

        model.addAttribute("bookList", bookService.getBookByName(bookName));
        return "search-result";
    }

    @GetMapping("/{id}/lend")
    public String lendBook(@PathVariable("id") Long id, Model model) {

        Book book = bookService.getByBookId(id);

        User user = getLoggedUser();

        bookService.lendBook(book, user);
        userService.borrowBook(book, user);

        logger.info("Book was successfully lent.");

        model.addAttribute("book", book);

        return "single-book";
    }

    @GetMapping("/{id}/return")
    public String returnBook(@PathVariable("id") Long id, Model model) {

        Book book = bookService.getByBookId(id);

        User user = getLoggedUser();
        bookService.getBackBook(book);
        userService.returnBookBook(book, user);
        logger.info("Book was successfully returned.");

        model.addAttribute("book", book);

        return "single-book";
    }

    private User getLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByEmail(auth.getName());
    }
}
