package io.github.koryl.prolibrary.data.repository;

import io.github.koryl.prolibrary.data.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBooksByBookNameContaining(String bookName);
}
