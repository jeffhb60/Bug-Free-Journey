package com.jeffhb60.bugfreejourney.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class OrderItemDTO {

    private Long orderItemId;
    private ProductDTO product;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;
}
