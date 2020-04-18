package com.mtit.microservice.deliveryservice.service;

import com.mtit.microservice.deliveryservice.model.DeliveryRequest;
import com.mtit.microservice.deliveryservice.model.DeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    // Get Authorized Customer Details
    public DeliveryResponse getDeliveryDetails(DeliveryRequest deliveryRequest){

        var deliveryDetails = new DeliveryRequest();

        deliveryDetails.setUserName(deliveryRequest.getUserName());

        ResponseEntity<DeliveryResponse> deliveryRequestResponse = restTemplate.postForEntity("http://localhost:8080/get-customer", deliveryDetails, DeliveryResponse.class);

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
