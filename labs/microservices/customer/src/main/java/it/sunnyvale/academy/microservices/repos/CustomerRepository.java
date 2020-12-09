package it.sunnyvale.academy.microservices.repos;

import it.sunnyvale.academy.microservices.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {


}
