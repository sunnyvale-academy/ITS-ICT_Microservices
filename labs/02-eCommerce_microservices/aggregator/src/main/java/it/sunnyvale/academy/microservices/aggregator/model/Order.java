package it.sunnyvale.academy.microservices.aggregator.model;

import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private String notifyToPhoneNr;
}
