
package com.rammonton.categoryservice.controller;

import com.rammonton.categoryservice.dto.request.CreateCategoryRequest;
import com.rammonton.categoryservice.dto.request.UpdateCategoryRequest;
import com.rammonton.categoryservice.dto.response.CategoryResponse;
import com.rammonton.categoryservice.enums.CategoryType;
import com.rammonton.categoryservice.service.CategoryService;
import com.rammonton.common.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private static final Long USER_ID = 1L;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(
            @Valid @RequestBody CreateCategoryRequest request) {

        CategoryResponse response =
                categoryService.createCategory(USER_ID, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<CategoryResponse>builder()
                                .success(true)
                                .message("Category created successfully.")
                                .data(response)
                                .build()
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategories() {

        List<CategoryResponse> response =
                categoryService.getCategories(USER_ID);

        return ResponseEntity.ok(
                ApiResponse.<List<CategoryResponse>>builder()
                        .success(true)
                        .message("Categories retrieved successfully.")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(
            @PathVariable Long id) {

        CategoryResponse response =
                categoryService.getCategory(USER_ID, id);

        return ResponseEntity.ok(
                ApiResponse.<CategoryResponse>builder()
                        .success(true)
                        .message("Category retrieved successfully.")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategoriesByType(
            @PathVariable CategoryType type) {

        List<CategoryResponse> response =
                categoryService.getCategoriesByType(USER_ID, type);

        return ResponseEntity.ok(
                ApiResponse.<List<CategoryResponse>>builder()
                        .success(true)
                        .message("Categories retrieved successfully.")
                        .data(response)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCategoryRequest request) {

        CategoryResponse response =
                categoryService.updateCategory(USER_ID, id, request);

        return ResponseEntity.ok(
                ApiResponse.<CategoryResponse>builder()
                        .success(true)
                        .message("Category updated successfully.")
                        .data(response)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(
            @PathVariable Long id) {

        categoryService.deleteCategory(USER_ID, id);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Category deleted successfully.")
                        .build()
        );
    }
}