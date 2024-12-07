package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.CategoryDTO;
import com.jeffhb60.bugfreejourney.dto.CategoryResponse;

public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long CategoryId);
}
