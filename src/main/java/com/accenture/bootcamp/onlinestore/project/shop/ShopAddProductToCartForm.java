package com.accenture.bootcamp.onlinestore.project.shop;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopAddProductToCartForm {
    private Integer quantity = 1;

    @Override
    public String toString() {
        return "AddProductToCartForm{" +
                "quantity=" + quantity +
                '}';
    }
}
