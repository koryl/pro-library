package io.github.koryl.prolibrary.web.application;

import io.github.koryl.prolibrary.business.service.BookService;
import io.github.koryl.prolibrary.data.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @MockBean
    private BookService bookService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldShowDefaultCoverWhenImgNotProvided() {

        Book mockBook = new Book();
        mockBook.setBookAuthor("Test, Author");
        mockBook.setBookName("Test Book");
        mockBook.setBookDescription("Lorem ipsum...");
        given(bookService);
        // TODO
    }
}
