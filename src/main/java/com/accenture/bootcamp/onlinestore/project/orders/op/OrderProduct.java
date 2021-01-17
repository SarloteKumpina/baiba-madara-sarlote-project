package com.accenture.bootcamp.onlinestore.project.orders.op;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderProduct {
        private long id;
        private Long productId;
        private int quantity;
        private long orderId;
    }

