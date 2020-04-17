package com.mtit.microservice.customerservice.repository;

import com.mtit.microservice.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByUserName(String username);

}
