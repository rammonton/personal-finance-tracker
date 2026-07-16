package com.rammonton.categoryservice.mapper;

import com.rammonton.categoryservice.dto.request.CreateCategoryRequest;
import com.rammonton.categoryservice.dto.request.UpdateCategoryRequest;
import com.rammonton.categoryservice.dto.response.CategoryResponse;
import com.rammonton.categoryservice.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryRequest request, Long userId) {

        return Category.builder()
                .userId(userId)
                .name(request.getName())
                .type(request.getType())
                .icon(request.getIcon())
                .color(request.getColor())
                .description(request.getDescription())
                .active(true)
                .build();
    }

    public void updateEntity(Category category, UpdateCategoryRequest request) {

        category.setName(request.getName());
        category.setType(request.getType());
        category.setIcon(request.getIcon());
        category.setColor(request.getColor());
        category.setDescription(request.getDescription());
        category.setActive(request.getActive());
    }

    public CategoryResponse toResponse(Category category) {

        return CategoryResponse.builder()
                .id(category.getId())
                .userId(category.getUserId())
                .name(category.getName())
                .type(category.getType())
                .icon(category.getIcon())
                .color(category.getColor())
                .description(category.getDescription())
                .active(category.getActive())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }
}