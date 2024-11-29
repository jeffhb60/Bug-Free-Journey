package com.jeffhb60.bugfreejourney.model;

import com.jeffhb60.bugfreejourney.repositories.CategoryRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity @Table(name = "products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {

    @Column(name = "product_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "special_price")
    private double specialPrice;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String productName, String description, Integer quantity, double price, double discount) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.image = "http://localhost:8080/images/default.png";
        this.specialPrice = this.price - this.price * this.discount * 0.01;
    }

    public Product(String productName, String description, Integer quantity, double price, double discount, Category category) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.price = discount;
        this.category = category;
        this.image = "http://localhost:8080/images/default.png";
        this.specialPrice = this.price - this.price * this.discount * 0.01;
    }
}
