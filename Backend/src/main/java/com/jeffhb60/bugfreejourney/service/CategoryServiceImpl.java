package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.CategoryDTO;
import com.jeffhb60.bugfreejourney.dto.CategoryResponse;
import com.jeffhb60.bugfreejourney.exceptions.APIException;
import com.jeffhb60.bugfreejourney.exceptions.CustomResourceNotFoundException;
import com.jeffhb60.bugfreejourney.model.Category;
import com.jeffhb60.bugfreejourney.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);
        if (categoryPage.isEmpty()) {
            return new CategoryResponse(List.of(),pageNumber, pageSize, 0L, 0, true);
        }
        List<CategoryDTO> categoryDTOS = categoryPage.getContent().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(pageNumber);
        categoryResponse.setPageSize(pageSize);
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category cat = categoryRepository.findByCategoryName(category.getCategoryName());
        if (cat != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists!");
        }
        Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO;
        savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO;
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Category", "categoryId", categoryId));
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}
