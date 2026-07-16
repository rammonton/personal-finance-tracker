package com.rammonton.categoryservice.dto.response;

import com.rammonton.categoryservice.enums.CategoryType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryResponse {

    private Long id;

    private Long userId;

    private String name;

    private CategoryType type;

    private String icon;

    private String color;

    private String description;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}