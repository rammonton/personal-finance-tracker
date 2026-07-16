package com.rammonton.categoryservice.service.impl;

import com.rammonton.categoryservice.dto.request.CreateCategoryRequest;
import com.rammonton.categoryservice.dto.request.UpdateCategoryRequest;
import com.rammonton.categoryservice.dto.response.CategoryResponse;
import com.rammonton.categoryservice.entity.Category;
import com.rammonton.categoryservice.enums.CategoryType;
import com.rammonton.categoryservice.exception.CategoryNotFoundException;
import com.rammonton.categoryservice.exception.DuplicateCategoryException;
import com.rammonton.categoryservice.mapper.CategoryMapper;
import com.rammonton.categoryservice.repository.CategoryRepository;
import com.rammonton.categoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(Long userId, CreateCategoryRequest request) {

        if (categoryRepository.existsByUserIdAndName(userId, request.getName())) {
            throw new DuplicateCategoryException(request.getName());
        }

        Category category = categoryMapper.toEntity(request, userId);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getCategories(Long userId) {

        return categoryRepository.findAllByUserId(userId)
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getCategoriesByType(Long userId,
                                                      CategoryType type) {

        return categoryRepository.findAllByUserIdAndType(userId, type)
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getCategory(Long userId, Long categoryId) {

        Category category = categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(
            Long userId,
            Long categoryId,
            UpdateCategoryRequest request) {

        Category category = categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        if (categoryRepository.existsByUserIdAndNameAndIdNot(
                userId,
                request.getName(),
                categoryId)) {

            throw new DuplicateCategoryException(request.getName());
        }

        categoryMapper.updateEntity(category, request);

        return categoryMapper.toResponse(category);
    }

    @Override
    public void deleteCategory(Long userId, Long categoryId) {

        Category category = categoryRepository
                .findByIdAndUserId(categoryId, userId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        category.setActive(false);
    }
}