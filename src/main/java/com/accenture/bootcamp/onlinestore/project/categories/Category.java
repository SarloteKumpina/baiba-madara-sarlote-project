package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import javax.persistence.ManyToMany;
import java.util.*;

public class Category {

    private Long id;
    private String name;
    private String imageUri;

    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String name, String imageUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
    }

//    public Category(CategoryRequest request) {
//        this.id = id;
//        this.name = request.getName();
//        this.imageUri = request.getImageUri();
//    }

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
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return id == that.id &&
                name.equals(that.name) &&
                imageUri.equals(that.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUri);
    }
}
