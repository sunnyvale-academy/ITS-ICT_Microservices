package it.sunnyvale.academy.microservices.customer.controllers;

import it.sunnyvale.academy.microservices.customer.model.Customer;
import it.sunnyvale.academy.microservices.customer.repos.CustomerRepository;
import it.sunnyvale.academy.microservices.customer.services.TraceService;
import it.sunnyvale.academy.microservices.customer.exceptions.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v2/customers")
public class CustomerController {

    @Autowired
    TraceService traceService;

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.PUT)
    public Customer addNewCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }


    // READ
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }else{
            throw new CustomerNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomers() {
        log.info("Get all customers");
        return customerRepository.findAll();
    }


    // UPDATE
    @RequestMapping(value = "/{customerId}", method = RequestMethod.POST)
    public Customer modifyCustomer(@RequestBody Customer customer, @RequestBody String customerId ) {
        return customerRepository.save(customer);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String customerId) {
        customerRepository.deleteById(customerId);
    }
}
