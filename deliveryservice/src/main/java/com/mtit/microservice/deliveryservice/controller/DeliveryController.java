package com.mtit.microservice.deliveryservice.controller;

import com.mtit.microservice.deliveryservice.model.DeliveryRequest;
import com.mtit.microservice.deliveryservice.model.DeliveryResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryController {

    @GetMapping("/")
    public String index(){
        return "Hello Delivery Service !";
    }

    @PostMapping(value = "/get-delivery-details", consumes = "application/json", produces = "application/json")
    public @ResponseBody DeliveryResponse getDeliveryDetails(@RequestBody DeliveryRequest deliveryRequest){
        return "";
    }
}
