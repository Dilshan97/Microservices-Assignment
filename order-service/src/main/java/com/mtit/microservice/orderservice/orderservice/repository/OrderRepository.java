package com.mtit.microservices.orderservice.orderserviceimplement.repository;

import com.mtit.microservices.orderservice.orderserviceimplement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
