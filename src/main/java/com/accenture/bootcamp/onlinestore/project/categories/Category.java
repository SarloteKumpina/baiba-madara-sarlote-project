package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Category {

    private Long id;

    @NotBlank(message = "Name is mandatory.")
    @Size(min = 3, max = 255, message = "Name size must be between 3 and 255 characters long.")
    private String name;

    @NotBlank(message = "ImageUri is mandatory.")
    @Size(min = 3, max = 255, message = "ImageUri size must be between 3 and 255 characters long.")
    private String imageUri;

    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "Category(Id: " + this.id + ", Name: " + this.name + ", ImageUri: " + this.imageUri + ")";
    }

    public boolean categoryIsNew() {
        return this.id == null;
    }

}
