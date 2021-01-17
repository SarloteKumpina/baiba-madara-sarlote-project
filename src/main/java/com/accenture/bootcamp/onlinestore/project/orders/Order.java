package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Order extends Customer {

    private Long orderId;
    private Long customerId;
    private LocalDateTime orderTime;
    private int statusId;
    private String userId;

    //For Order view-items
    private Long productId;
    private int quantity;
    private String imageUri;
    private String productName;
    private BigDecimal productPrice;

}

