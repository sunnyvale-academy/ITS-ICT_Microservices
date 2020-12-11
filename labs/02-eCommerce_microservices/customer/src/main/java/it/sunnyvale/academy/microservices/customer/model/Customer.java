package it.sunnyvale.academy.microservices.customer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Customer {

    @Id
    private String customerId;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String surname;


}
