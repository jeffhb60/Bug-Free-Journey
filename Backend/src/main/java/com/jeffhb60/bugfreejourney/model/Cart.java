package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "carts")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Cart {

    @Column(name = "cart_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @Column(name = "total_price")
    private Double totalPrice = 0.0;
}
