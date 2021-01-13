package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

public class Category {

    private Long id;

    @NotBlank(message = "Name is mandatory.")
    @Size(min=3, max=255, message = "Name size must be between 3 and 255 characters long.")
    private String name;

    @NotBlank(message = "ImageUri is mandatory.")
    @Size(min=3, max=255, message = "ImageUri size must be between 3 and 255 characters long.")
    private String imageUri;

    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String name, String imageUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
    }

    public Long getId() {
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

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(imageUri, category.imageUri) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUri);
    }

//    @Override
//    public String toString() {
//        return this.getName();
//    }

    @Override
    public String toString() {
        return "Category(Id: " + this.id + ", Name: " + this.name + ", ImageUri: " + this.imageUri + ")";
    }

    public boolean categoryIsNew() {
        return this.id == null;
    }



}
