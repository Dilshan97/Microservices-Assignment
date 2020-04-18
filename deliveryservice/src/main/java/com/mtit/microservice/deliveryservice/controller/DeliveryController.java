package com.mtit.microservice.deliveryservice.controller;

import com.mtit.microservice.deliveryservice.model.DeliveryRequest;
import com.mtit.microservice.deliveryservice.model.DeliveryResponse;
import com.mtit.microservice.deliveryservice.service.DeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryServiceImpl deliveryService;

    //Root end-point
    @GetMapping("/")
    public String index(){
        return "Hello Delivery Service !";
    }

    //Get Customer Details API end-point
    @PostMapping(value = "/get-delivery-details", consumes = "application/json", produces = "application/json")
    public @ResponseBody DeliveryResponse getDeliveryDetails(@RequestBody DeliveryRequest deliveryRequest, @RequestHeader(name = "Content-Type") String Content, @RequestHeader(name = "Authorization") String Authorization){

        System.out.println(deliveryRequest);

        return deliveryService.getDeliveryDetails(deliveryRequest, Content, Authorization);

    }
}
