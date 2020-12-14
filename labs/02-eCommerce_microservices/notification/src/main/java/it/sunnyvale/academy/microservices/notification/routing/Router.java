package it.sunnyvale.academy.microservices.notification.routing;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Router extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Kafka Consumer
        from("kafka:{{kafka.sms.topic}}?brokers={{kafka.broker.urls}}")
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}")
                .to("log:?level=INFO&showBody=true");

    }

}
