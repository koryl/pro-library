package io.github.koryl.prolibrary.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private long id;
    @Column(name="BOOK_NAME")
    private String bookName;
    @Column(name="BOOK_AUTHOR")
    private String bookAuthor;
    @Column(name="BOOK_DESCRIPTION")
    private String bookDescription;
}
