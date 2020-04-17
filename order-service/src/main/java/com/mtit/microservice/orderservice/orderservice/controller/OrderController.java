package com.mtit.microservices.orderservice.orderserviceimplement.controller;

import com.mtit.microservices.orderservice.orderserviceimplement.exception.ResourceNotFoundException;
import com.mtit.microservices.orderservice.orderserviceimplement.model.Order;
import com.mtit.microservices.orderservice.orderserviceimplement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    //create get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //create an order
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order){
        return  orderRepository.save(order);
    }

    //get order by id
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable (value = "id") long orderId
                                              ,@RequestBody Order orderInfo  ) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("The order id not found::" + orderId));
        return ResponseEntity.ok().body(order);
    }

    //update the order
    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable (value = "id") long orderId
                             , @RequestBody Order orderInfo) throws ResourceNotFoundException{
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("The order id not found::" + orderId));
        order.setOrderName(orderInfo.getOrderName());
        order.setOrderType(orderInfo.getOrderType());
        order.setOrderDetails(orderInfo.getOrderDetails());
        order.setOrderDate(orderInfo.getOrderDate());
        orderRepository.save(order);
        return ResponseEntity.ok().body(order);
    }

    //delete the order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable (value = "id") long orderId) throws ResourceNotFoundException {
        orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("The Employee ID not found::" + orderId));
        return ResponseEntity.ok().build();
    }
}
