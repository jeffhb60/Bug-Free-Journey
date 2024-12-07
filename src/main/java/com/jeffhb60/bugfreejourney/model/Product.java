package com.jeffhb60.bugfreejourney.model;

import com.jeffhb60.bugfreejourney.repositories.CategoryRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "products")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Product {

    @Column(name = "product_id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "product_name")
    @NotBlank @Size(min = 3, message = "Product name must contain at least 3 characters")
    private String productName;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    @NotBlank @Size(min = 6, message = "Product description must contain at least 6 characters")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "special_price")
    private double specialPrice;

    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne @JoinColumn(name = "seller_id")
    private User user;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();

    public Product(String productName, String description, Integer quantity, double price, double discount, Category category) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = "placeholder.png";
        this.specialPrice = price - price * discount * 0.01;
    }
}

