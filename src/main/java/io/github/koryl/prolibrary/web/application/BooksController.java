package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.business.service.BookService;
import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/library/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String books(Model model) {

        List<Book> allBooksList = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooksList);
        return "books";
    }
}
