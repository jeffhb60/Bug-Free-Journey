package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.CartDTO;

import java.util.List;

public interface CartService {

    CartDTO addProductToCart(Long productId, Integer quantity);

    String deleteProductFromCart(Long cartId, Long productId);

    List<CartDTO> getAllCarts();

    CartDTO getCart(String email, Long cartId);

    void updateProductInCarts(Long cartId, Long productId);

    CartDTO updateProductQuantityInCart(Long productId, Integer quantity);



}
