package io.github.koryl.prolibrary.web.service;

import io.github.koryl.prolibrary.data.entity.Book;
import io.github.koryl.prolibrary.data.repository.BookRepository;
import io.github.koryl.prolibrary.web.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/library/api")
public class BooksServiceController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<BookDto> allBooks() {

        List<BookDto> bookDtoList = new ArrayList<>();
        Iterable<Book> books =  bookRepository.findAll();
        for (Book book : books) {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setBookAuthor(book.getBookAuthor());
            bookDto.setBookName(book.getBookName());
            bookDto.setBookDescription(book.getBookDescription());
            bookDto.setBorrowed(book.isBorrowed());

            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }
}
