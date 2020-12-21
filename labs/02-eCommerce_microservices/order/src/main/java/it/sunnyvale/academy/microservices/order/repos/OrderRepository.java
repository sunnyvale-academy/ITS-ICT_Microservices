package it.sunnyvale.academy.microservices.order.repos;

import it.sunnyvale.academy.microservices.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
