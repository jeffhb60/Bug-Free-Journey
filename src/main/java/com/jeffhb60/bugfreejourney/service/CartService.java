package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.CartDTO;

public interface CartService {
    CartDTO addProductToCart(Long productId, Integer quantity);
}
