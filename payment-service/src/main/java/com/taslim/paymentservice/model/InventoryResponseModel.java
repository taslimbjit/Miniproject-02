package com.taslim.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseModel {
    private Long id;
    private String bookName;
    private String authorName;
    private String category;
    private String description;
    private Long price;
    private Long quantity;

}
