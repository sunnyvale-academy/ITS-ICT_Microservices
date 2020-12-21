package it.sunnyvale.academy.microservices.customer.repos;

import it.sunnyvale.academy.microservices.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {


}
