package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    private Long id;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 3, max = 255, message = "Name size must be between 3 and 255 characters long.")
    private String name;

    @NotEmpty(message = "The product has to be assigned to a category.")
    private List<Long> categoryIds = new ArrayList<>();

    @NotNull(message = "Price is mandatory! The price cannot be lower than 0.01.")
    @DecimalMin(value = "0.01", inclusive = true, message = "The price cannot be lower than 0.01.")
    private BigDecimal price;

    @NotBlank(message = "Description is mandatory.")
    @Size(min = 3, max = 255, message = "Description size must be between 3 and 255 characters long.")
    private String description;

    @NotNull(message = "Quantity value cannot be empty.")
    @Min(value = 0, message = "Quantity cannot be less than 0.")
    private Integer stock;

    @NotBlank(message = "Image URI is mandatory.")
    @Size(min = 3, max = 255, message = "Image URI size must be between 3 and 255 characters long.")
    private String imageUri;

    private List<Category> categories = new ArrayList<>();

    public boolean productIsNew() {
        return this.id == null;
    }
}
