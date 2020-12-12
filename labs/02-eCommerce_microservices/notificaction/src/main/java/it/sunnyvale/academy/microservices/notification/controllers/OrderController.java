package it.sunnyvale.academy.microservices.notification.controllers;

import it.sunnyvale.academy.microservices.notification.model.Order;
import it.sunnyvale.academy.microservices.notification.repos.OrderRepository;
import it.sunnyvale.academy.microservices.notification.services.TraceService;
import it.sunnyvale.academy.microservices.notification.exceptions.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/v2/orders")
public class OrderController {

    @Autowired
    TraceService traceService;

    @Autowired
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.PUT)
    public Order addNewOrder(@Valid @RequestBody Order order) {
        return orderRepository.save(order);
    }


    // READ
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()){
            return orderOptional.get();
        }else{
            throw new OrderNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAllOrders() {
        log.info("Get all orders");
        List<Order> result = new ArrayList<Order>();
        Iterable<Order> iterable = orderRepository.findAll();
        iterable.forEach(result::add);
        return result;
    }


    // UPDATE
    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    public Order modifyOrder(@RequestBody Order order, @RequestBody String orderId ) {
        return orderRepository.save(order);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
