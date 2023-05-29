package com.taslim.paymentservice.service;


import com.taslim.paymentservice.model.OrderRequestModel;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<Object> payment(OrderRequestModel orderRequestModel);
}
