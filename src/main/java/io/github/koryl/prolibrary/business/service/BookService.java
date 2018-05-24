package io.github.koryl.prolibrary.business.service;

import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {

        Iterable<Book> books = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        books.forEach(bookList::add);
        return bookList;
    }
}
