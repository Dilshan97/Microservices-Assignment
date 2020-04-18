package com.mtit.microservice.deliveryservice.controller;

import com.mtit.microservice.deliveryservice.model.DeliveryRequest;
import com.mtit.microservice.deliveryservice.model.DeliveryResponse;
import com.mtit.microservice.deliveryservice.service.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl deliveryService;


    @GetMapping("/")
    public String index(){
        return "Hello Delivery Service !";
    }

    @PostMapping(value = "/get-delivery-details", consumes = "application/json", produces = "application/json")
    public @ResponseBody DeliveryResponse getDeliveryDetails(@RequestBody DeliveryRequest deliveryRequest){

        System.out.println(deliveryRequest);

        return deliveryService.getDeliveryDetails(deliveryRequest);

    }
}
