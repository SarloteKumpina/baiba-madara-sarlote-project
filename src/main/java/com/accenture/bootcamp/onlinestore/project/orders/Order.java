package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Order {

    private Long id;
    private Long customerId;
    private LocalDateTime orderTime;
    private int statusId;
    private String userId;

    //Order status
    private String statusName;

    //Customer information
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private BigDecimal orderTotalSum;

    //For Order view-items
    private Long productId;
    private int quantity;
    private String imageUri;
    private String productName;
    private BigDecimal productPrice;

}

