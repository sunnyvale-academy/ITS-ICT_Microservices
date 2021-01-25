package org.example.borrow;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.borrow.controllers.BorrowController;
import org.example.borrow.services.TraceService;
import org.example.borrow.repos.BorrowRepository;
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
@WebMvcTest(BorrowController.class)
@AutoConfigureMockMvc
public class BorrowControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BorrowRepository repository;

    @MockBean
    TraceService traceService;
    
    @Test
    public void testGetAllBorrows() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/borrows")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
