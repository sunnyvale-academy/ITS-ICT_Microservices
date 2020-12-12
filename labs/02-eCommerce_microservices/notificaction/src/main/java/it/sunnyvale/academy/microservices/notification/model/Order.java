package it.sunnyvale.academy.microservices.notification.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long orderId;

    private String customerId;

}
