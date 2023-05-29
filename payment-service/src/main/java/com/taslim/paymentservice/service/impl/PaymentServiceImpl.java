package com.taslim.paymentservice.service.impl;



import com.taslim.paymentservice.model.InventoryResponseModel;
import com.taslim.paymentservice.model.OrderRequestModel;
import com.taslim.paymentservice.model.OrderResponseModel;
import com.taslim.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WebClient.Builder webClientBuilder;



    @Override
    public ResponseEntity<Object> payment(OrderRequestModel orderRequestModel) {
                Long id = orderRequestModel.getUserId();

        AtomicReference<Long> totalBill= new AtomicReference<>(0L);

            if (id != null){


                List<InventoryResponseModel> inventoryResponseModel = orderRequestModel.getOrderItemRequestModelList()
                        .stream().
                        map(e -> { InventoryResponseModel inventoryResponseModel1 = (InventoryResponseModel) webClientBuilder.build().get(
                        );

                    inventoryResponseModel1.setQuantity(e.getQuantity());

                    totalBill.updateAndGet(v -> v + inventoryResponseModel1.getPrice() * inventoryResponseModel1.getQuantity());

                    return inventoryResponseModel1;
                }   ).toList();


                Long total = totalBill.get();
            }




        return null;
    }
}
