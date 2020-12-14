package it.sunnyvale.academy.microservices.order.services;

import it.sunnyvale.academy.microservices.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class NotificationClient {

    @Value("${kafka.sms.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendSMS(Order order){
        kafkaTemplate.send(topic, order);
    }

}
