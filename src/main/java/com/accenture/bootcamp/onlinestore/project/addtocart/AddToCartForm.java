package com.accenture.bootcamp.onlinestore.project.addtocart;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddToCartForm {
    private Integer quantity = 1;

    @Override
    public String toString() {
        return "AddProductToCartForm{" +
                "quantity=" + quantity +
                '}';
    }
}
