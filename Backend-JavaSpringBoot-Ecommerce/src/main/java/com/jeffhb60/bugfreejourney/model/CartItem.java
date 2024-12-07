package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "cart_items")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CartItem {

    @Column(name = "cart_item_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "discount")
    private double discount;

    @Column(name = "product_price")
    private double productPrice;
}
