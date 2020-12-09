package it.sunnyvale.academy.microservices.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String surname;


}
