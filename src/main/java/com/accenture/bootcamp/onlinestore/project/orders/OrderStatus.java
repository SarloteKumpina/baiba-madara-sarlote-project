package com.accenture.bootcamp.onlinestore.project.orders;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderStatus {

    private int orderStatusId;
    private String name;
}
