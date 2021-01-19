package com.accenture.bootcamp.onlinestore.project.orderproduct;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderProduct {
        private Long id;
        private Long productId;
        private int quantity;
        private Long orderId;
    }

