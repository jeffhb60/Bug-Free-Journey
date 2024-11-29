package com.jeffhb60.bugfreejourney.repositories;

import com.jeffhb60.bugfreejourney.model.Category;
import com.jeffhb60.bugfreejourney.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryOrderByPriceAsc(Category category);
    List<Product> findByProductNameLikeIgnoreCaseOrderByPriceAsc(String productKeyword);
}
