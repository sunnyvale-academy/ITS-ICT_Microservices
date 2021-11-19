package it.sunnyvale.academy.microservices.aggregator.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerOrders {

    private String customerId;
    private String customerName;
    private String customerSurname;
    private List<Order> orders;

}
