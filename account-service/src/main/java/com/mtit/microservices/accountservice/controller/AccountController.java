package com.mtit.microservices.accountservice.controller;

import com.mtit.microservices.accountservice.dto.UserRequest;
import com.mtit.microservices.accountservice.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class AccountController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody UserResponse createUser(@RequestBody UserRequest userRequest) {

        var userResponse = new UserResponse();
        userResponse.setUserId(UUID.randomUUID().toString());
        userResponse.setMessage("User Creation is successful");
        return userResponse;
    }
}
