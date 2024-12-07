package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "orders")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "order_date")
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "order_status")
    private String orderStatus;

    // Reference to Address
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
