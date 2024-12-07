package com.jeffhb60.bugfreejourney.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CartItemDTO {
    private Long cartItemId;
    private CartDTO cart;
    private ProductDTO productDTO;
    private Integer quantity;
    private Double discount;
    private Double productPrice;
}

