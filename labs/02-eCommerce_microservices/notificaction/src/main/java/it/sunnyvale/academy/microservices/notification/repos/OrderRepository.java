package it.sunnyvale.academy.microservices.notification.repos;

import it.sunnyvale.academy.microservices.notification.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
