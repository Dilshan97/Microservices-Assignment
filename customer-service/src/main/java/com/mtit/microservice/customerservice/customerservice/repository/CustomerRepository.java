package com.mtit.microservice.customerservice.customerservice.repository;

import com.mtit.microservice.customerservice.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);

    Customer findByUserName(String username);
}
