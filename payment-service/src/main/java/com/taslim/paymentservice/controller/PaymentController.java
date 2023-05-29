package com.taslim.paymentservice.controller;


import com.taslim.paymentservice.model.OrderRequestModel;
import com.taslim.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    @ResponseBody
    ResponseEntity<Object>  payment(@RequestBody OrderRequestModel orderRequestModel){
        return paymentService.payment(orderRequestModel);
    }

}
