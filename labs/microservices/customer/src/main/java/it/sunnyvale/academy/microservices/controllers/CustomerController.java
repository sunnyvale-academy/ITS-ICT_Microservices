package it.sunnyvale.academy.microservices.controllers;

import it.sunnyvale.academy.microservices.exceptions.CustomerNotFoundException;
import it.sunnyvale.academy.microservices.model.Customer;
import it.sunnyvale.academy.microservices.repos.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Customer addNewCustomers(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getUser(@PathVariable String customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }else{
            throw new CustomerNotFoundException();
        }
    }
}
