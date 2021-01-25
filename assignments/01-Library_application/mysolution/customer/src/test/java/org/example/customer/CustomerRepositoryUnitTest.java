package org.example.customer;

import org.example.customer.model.Customer;
import org.example.customer.repos.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryUnitTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void testEmptyDB(){
        assertEquals(0,customerRepository.findAll().size()  );
    }

    @Test
    public void testAddOneCustomer(){
        Customer customer = new Customer();
        customer.setName("Pippo");
        customer.setSurname("Franco");
        customer.setCustomerId("1234567890");
        customerRepository.save(customer);
        assertEquals(1,customerRepository.findAll().size()  );
    }

}
