package com.mtit.microservice.customerservice.customerservice.controller;

import com.mtit.microservice.customerservice.customerservice.model.AuthRequest;
import com.mtit.microservice.customerservice.customerservice.model.AuthResponse;
import com.mtit.microservice.customerservice.customerservice.model.Customer;
import com.mtit.microservice.customerservice.customerservice.model.CustomerRequest;
import com.mtit.microservice.customerservice.customerservice.repository.CustomerRepository;
import com.mtit.microservice.customerservice.customerservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String index() {
        return "Hello ! ABC Company Customer Micro service";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUserName(),
                            authRequest.getPassword()
                    )
            );
        } catch (Exception ex) {
            throw new Exception("Invalid Username / Password " + ex);
        }

        return jwtUtil.generateToken(authRequest.getUserName());
    }


    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    AuthResponse createCustomer(@RequestBody CustomerRequest customerRequest) {

        System.out.println("User Details : " + customerRequest);

        Customer register = new Customer(
                "cus-" + UUID.randomUUID().toString(),
                customerRequest.getFirstName(),
                customerRequest.getLastName(),
                customerRequest.getEmail(),
                customerRequest.getPhone(),
                customerRequest.getAddress(),
                customerRequest.getUserName(),
                customerRequest.getPassword());

        customerRepository.save(register);

        var customerResponse = new AuthResponse();

        customerResponse.setCustomerId(register.getCustomerId());

        customerResponse.setUserName(customerRequest.getUserName());

        customerResponse.setMessage("Successfully created the customer");

        return customerResponse;
    }
}
