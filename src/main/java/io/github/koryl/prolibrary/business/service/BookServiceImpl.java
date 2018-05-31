package io.github.koryl.prolibrary.business.service;

import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.entity.User;
import io.github.koryl.prolibrary.data.repository.BookRepository;
import io.github.koryl.prolibrary.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
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

            user.getBorrowedBooks().add(book);
            userRepository.save(user);

            logger.info("Book was successfully lent.");
        }
    }
}
