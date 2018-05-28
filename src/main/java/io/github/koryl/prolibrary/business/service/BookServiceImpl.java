package io.github.koryl.prolibrary.business.service;

import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.entity.User;
import io.github.koryl.prolibrary.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {

        Iterable<Book> books = bookRepository.findAll();
        List<Book> bookList = new ArrayList<>();
        books.forEach(bookList::add);
        return bookList;
    }

    public Book saveBook() {
        return null;
    }

    public Book getByBookId(Long id) {

        Optional<Book> opBook = bookRepository.findById(id);

        return opBook.orElseGet(Book::new);
    }

    public List<Book> getBookByName(String bookName) {

        return bookRepository.findBooksByBookNameContaining(bookName);
    }

    @Transactional
    public void lendBook(Book book, User user) {

        if(!book.isBorrowed()) {

            book.setBorrowed(true);
            book.setUser(user);
            bookRepository.save(book);
        }
    }

    @Transactional
    public void getBackBook(Book book) {

        if(book.isBorrowed()) {

            book.setBorrowed(false);
            book.setUser(null);
            bookRepository.save(book);
        }
    }
}
