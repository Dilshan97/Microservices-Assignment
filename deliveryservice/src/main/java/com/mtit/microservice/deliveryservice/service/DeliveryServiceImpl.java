package com.mtit.microservice.deliveryservice.service;

import com.mtit.microservice.deliveryservice.model.DeliveryRequest;
import com.mtit.microservice.deliveryservice.model.DeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    // Get Authorized Customer Details
    public DeliveryResponse getDeliveryDetails(DeliveryRequest deliveryRequest, @RequestHeader(name = "Content-Type") String Content, @RequestHeader(name = "Authorization") String Authorization){


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Content);
        headers.add("Authorization", Authorization);

        var deliveryDetails = new DeliveryRequest();

        deliveryDetails.setUserName(deliveryRequest.getUserName());

        HttpEntity<DeliveryRequest> request = new HttpEntity<>(deliveryDetails, headers);

        ResponseEntity<DeliveryResponse> deliveryRequestResponse = restTemplate.postForEntity("http://localhost:8080/get-customer", request, DeliveryResponse.class);

        System.out.println(deliveryRequestResponse);

        var deliveryResponse = new DeliveryResponse();

        deliveryResponse.setCustomerId(deliveryRequestResponse.getBody().getCustomerId());

        deliveryResponse.setFirstName(deliveryRequestResponse.getBody().getFirstName());

        deliveryResponse.setLastName(deliveryRequestResponse.getBody().getLastName());

        deliveryResponse.setEmail(deliveryRequestResponse.getBody().getEmail());

        deliveryResponse.setPhone(deliveryRequestResponse.getBody().getPhone());

        deliveryResponse.setAddress(deliveryRequestResponse.getBody().getAddress());

        return deliveryResponse;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
