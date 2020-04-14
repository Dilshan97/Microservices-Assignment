package com.mtit.microservice.customerservice.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/")
    public String index(){
        return "Hello ! ABC Company Customer Microservice";
    }
}
