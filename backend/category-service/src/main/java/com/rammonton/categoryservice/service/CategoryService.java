package com.rammonton.categoryservice.service;

import com.rammonton.categoryservice.dto.request.CreateCategoryRequest;
import com.rammonton.categoryservice.dto.request.UpdateCategoryRequest;
import com.rammonton.categoryservice.dto.response.CategoryResponse;
import com.rammonton.categoryservice.enums.CategoryType;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(Long userId, CreateCategoryRequest request);

    List<CategoryResponse> getCategories(Long userId);

    List<CategoryResponse> getCategoriesByType(Long userId, CategoryType type);

    CategoryResponse getCategory(Long userId, Long categoryId);

    CategoryResponse updateCategory(
            Long userId,
            Long categoryId,
            UpdateCategoryRequest request
    );

    void deleteCategory(Long userId, Long categoryId);

}