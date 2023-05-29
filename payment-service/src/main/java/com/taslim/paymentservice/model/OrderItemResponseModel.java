package com.taslim.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponseModel {
    private Long id;
    private Long bookId;
    private String bookName;
    private String authorName;
    private Long price;
    private Long quantity;
}
