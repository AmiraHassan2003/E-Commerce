package com.example.ECommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_of_category")
    private String nameOfCategory;

    @OneToMany(mappedBy = "category",
            fetch = FetchType.LAZY ,
            cascade = {
                    CascadeType.DETACH , CascadeType.MERGE,
                    CascadeType.PERSIST , CascadeType.REFRESH
            })
    private List<Product> products;

    public Category(){

    }

    public Category(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCategory() {
        return this.nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", NameOfCategory='" + this.nameOfCategory + '\'' +
                '}';
    }

    public void addProducts(Product product){
        if(this.products == null){
            this.products = new ArrayList<>();
        }
        this.products.add(product);
        product.setCategory(this);
    }
}
