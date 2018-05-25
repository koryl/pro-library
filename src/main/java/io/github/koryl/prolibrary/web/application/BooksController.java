package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.business.service.BookServiceImpl;
import io.github.koryl.prolibrary.data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library/books")
public class BooksController {

    private final BookServiceImpl bookService;

    @Autowired
    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String books(Model model) {

        List<Book> allBooksList = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooksList);
        return "books";
    }

    @GetMapping("/{id}")
    public String selectedBook(Model model, @PathVariable Long id) {

        model.addAttribute("book", bookService.getByBookId(id));
        return "single-book";
    }

    @PostMapping("/search")
    public String searchBook(Model model, @RequestParam("bookName") String bookName) {

        model.addAttribute("bookList", bookService.getBookByName(bookName));
        return "search-result";
    }
}
