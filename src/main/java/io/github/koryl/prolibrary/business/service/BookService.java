package io.github.koryl.prolibrary.business.service;

import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.entity.User;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book saveBook();

    void lendBook(Book book, User user);

    void getBackBook(Book book);
}
