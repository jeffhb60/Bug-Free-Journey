package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.CartDTO;

import java.util.List;

public interface CartService {
    CartDTO addProductToCart(Long productId, Integer quantity);
    List<CartDTO> getAllCarts();
    CartDTO getCart(String email, Long cartId);
}
