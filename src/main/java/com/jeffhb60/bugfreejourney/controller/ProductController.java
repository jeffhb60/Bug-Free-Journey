package com.jeffhb60.bugfreejourney.controller;

import com.jeffhb60.bugfreejourney.dto.ProductDTO;
import com.jeffhb60.bugfreejourney.dto.ProductResponse;
import com.jeffhb60.bugfreejourney.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.jeffhb60.bugfreejourney.config.AppConstants.*;

@RestController @RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    public final ProductService productService;

    @PostMapping("admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO,
                                                 @PathVariable Long categoryId){
        ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/products")
    public ResponseEntity<ProductResponse> getAllProducts(
            @RequestParam(name = "pageNumber", defaultValue = PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = SORT_PRODUCTS_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = SORT_ORDER, required = false) String sortOrder
    ){

        ProductResponse productResponse = productService.getAllProducts(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/products")
    public ResponseEntity<ProductResponse> getProductsByCategory(@PathVariable Long categoryId){
        ProductResponse productResponse = productService.searchByCategory(categoryId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/products/keyword/{productKeyword}")
    public ResponseEntity<ProductResponse> getProductByKeyword(@PathVariable String productKeyword) {
        ProductResponse productResponse = productService.searchProductsByKeyword(productKeyword);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/public/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO productDTO = productService.getProductById(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,
                                                    @PathVariable Long productId) {
        ProductDTO savedpdatedProductDTO = productService.updateProduct(productId, productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId) {
        ProductDTO savedProductDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(savedProductDTO, HttpStatus.OK);
    }
}
