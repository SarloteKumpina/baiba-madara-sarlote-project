package com.accenture.bootcamp.onlinestore.project.orders.op;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderProduct {

    private long id;
    private List<Long> productIds = new ArrayList<>();
    private int quantity;
    private long orderId;

}
