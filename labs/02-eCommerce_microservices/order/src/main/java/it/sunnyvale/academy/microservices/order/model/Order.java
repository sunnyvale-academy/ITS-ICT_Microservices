package it.sunnyvale.academy.microservices.order.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long orderId;

    private String customerId;

    private String notifyToPhoneNr;


}
