package it.sunnyvale.academy.microservices.aggregator.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import it.sunnyvale.academy.microservices.aggregator.model.CustomerOrders;
import it.sunnyvale.academy.microservices.aggregator.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Query implements GraphQLQueryResolver {
    public CustomerOrders allCustomerOrders(String customerId, int limit) {
        CustomerOrders customerOrders = new CustomerOrders();

        Order order = new Order();
        order.setOrderId(1L);
        order.setNotifyToPhoneNr("12345");

        ArrayList<Order> orderList = new ArrayList();
        orderList.add(order);

        customerOrders.setOrders(orderList);
        customerOrders.setCustomerId("1234");
        customerOrders.setCustomerSurname("Rossi");
        customerOrders.setCustomerName("Mario");
        return customerOrders;
    }
}