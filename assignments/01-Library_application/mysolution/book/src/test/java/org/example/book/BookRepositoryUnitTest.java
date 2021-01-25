package org.example.book;

import org.example.book.models.Book;
import org.example.book.repos.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import javax.validation.constraints.NotBlank;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0,bookRepository.findAll().size()  );
    }

    @Test
    public void testAddOneBook(){
        Book book = new Book();
        book.setTitle("Pippo e le sue avventure");
        book.setBookId("1234567890");
        bookRepository.save(book);
        assertEquals(1,bookRepository.findAll().size()  );

    }

}
