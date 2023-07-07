package it.sunnyvale.academy.microservices.notification.test;

import it.sunnyvale.academy.microservices.notification.routing.Router;
import org.apache.camel.*;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.*;
import org.apache.camel.test.spring.junit5.CamelSpringTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@SpringBootTest
//@ActiveProfiles("test")
//@RunWith(CamelSpringBootRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(CamelSpringRunner.class)
//@RunWith(CamelCdiRunner.class)

@CamelSpringTest
@ContextConfiguration(classes = Router.class)
public class RouteTesting {


        @EndpointInject(uri = "mock:log:*")
        protected MockEndpoint resultEndpoint;

        @Produce(uri = "kafka:{{kafka.sms.topic}}?brokers={{kafka.broker.urls}}")
        protected ProducerTemplate template;

        @DirtiesContext
        @Test
        public void testSendMatchingMessage() throws Exception {
            String expectedBody = "<matched/>";

            resultEndpoint.expectedBodiesReceived(expectedBody);
            template.sendBodyAndHeader(expectedBody, "foo", "bar");

            resultEndpoint.assertIsSatisfied();
        }
}
