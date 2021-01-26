package org.example.borrow;

import org.example.borrow.model.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BorrowRepositoryUnitTest {

    @Autowired
    private BorrowRepository borrowRepository;


    @Test
    public void testEmptyDB(){
        AtomicInteger cont = new AtomicInteger();
        borrowRepository.findAll().forEach(borrow -> {
            cont.getAndIncrement();
        });
        assertEquals(0, cont.get());
    }

    @Test
    public void testAddOneBorrow(){
        AtomicInteger cont = new AtomicInteger();
        Borrow borrow = new Borrow();
        borrow.setBorrowId((long) 112324);
        borrow.setCustomerId("4532521354");
        borrow.setBookId("12453243542");
        borrow.setNotifyToPhoneNr("2312313435");
        borrowRepository.save(borrow);
        borrowRepository.findAll().forEach(borrowing -> {
            cont.getAndIncrement();
        });
        assertEquals(1,cont.get()  );

    }

}
