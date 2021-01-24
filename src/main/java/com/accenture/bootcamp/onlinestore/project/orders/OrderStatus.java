package com.accenture.bootcamp.onlinestore.project.orders;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class OrderStatus {

    @NotEmpty(message = "Status must be selected.")
    private Integer id;
    private String name;
}
