package it.sunnyvale.academy.microservices.notification.model;

import lombok.Data;


@Data
public class Order {

    private Long orderId;

    private String customerId;

}
