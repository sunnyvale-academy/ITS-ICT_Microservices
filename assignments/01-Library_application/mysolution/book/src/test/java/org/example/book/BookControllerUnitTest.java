package org.example.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.book.controllers.BookController;
import org.example.book.services.TraceService;
import org.example.book.repos.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository repository;

    @MockBean
    TraceService traceService;

    @Test
    public void testGetAllBooks() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/books")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
