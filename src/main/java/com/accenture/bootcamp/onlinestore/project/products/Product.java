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

    private List<Long> categoryIds = new ArrayList<>();

    @DecimalMin(value = "0.01", inclusive = true, message = "The price cannot be lower than 0.01.")
    //@Digits(integer = 6, fraction = 2, message = "The Price must be at least 0.01")
    //@Size(min = 0.01, message = "The Price must be at least 0.01")
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

    //@NotEmpty(message = "The product has to assigned to a category.")
    private List<Category> categories = new ArrayList<>();

    public boolean productIsNew() {
        return this.id == null;
    }

 /*   public Product() {
    }*/

 /*   public Product(Long id, String name, List<Long> categoryIds, BigDecimal price,
                   String description, int stock, String imageUri) {
        this.id = id;
        this.name = name;
        this.categoryIds = categoryIds;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.imageUri = imageUri;
    }*/

 /*   public Product(ProductRequest request) {
        this.id = id;
        this.name = request.getName();
        this.categoryIds = request.getCategoryIds();
        this.price = request.getPrice();
        this.description = request.getDescription();
        this.stock = request.getStock();
        this.imageUri = request.getImageUri();
    }*/

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }*/

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return id == products.id &&
                categoryIds == products.categoryIds &&
                stock == products.stock &&
                name.equals(products.name) &&
                price.equals(products.price) &&
                description.equals(products.description) &&
                imageUri.equals(products.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryIds, price, description, stock, imageUri);
    }*/
}
