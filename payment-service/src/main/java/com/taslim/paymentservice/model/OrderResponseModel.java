package com.taslim.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseModel {
    private Long id;
    private Long userId;
    private String address;
    private String phone;
    private Long totalBill;


    private List<OrderItemResponseModel> orderItemResponseModelList;
}
