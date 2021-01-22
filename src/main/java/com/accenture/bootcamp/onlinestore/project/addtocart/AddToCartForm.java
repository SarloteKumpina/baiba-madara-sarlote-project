package com.accenture.bootcamp.onlinestore.project.addtocart;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
//@Validated
@NoArgsConstructor
public class AddToCartForm {

    @NotNull(message = "Quantity value cannot be empty.")
    @Min(value = 1, message = "Quantity cannot be less than 1.")
    private Integer quantity = 1;

    @Override
    public String toString() {
        return "AddProductToCartForm{" +
                "quantity=" + quantity +
                '}';
    }

}
