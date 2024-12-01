package com.jeffhb60.bugfreejourney.controller;

import com.jeffhb60.bugfreejourney.dto.ProductDTO;
import com.jeffhb60.bugfreejourney.service.FileService;
import com.jeffhb60.bugfreejourney.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor @RestController @RequestMapping("/api")
public class FileController {

    private final ProductService productService;

    @PutMapping("/public/products/{productId}/images")
    ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId,
                                                  @RequestParam("Image") MultipartFile image) {
        ProductDTO updatedProduct = null;
        try {
            updatedProduct = productService.updateProductImage(productId, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
