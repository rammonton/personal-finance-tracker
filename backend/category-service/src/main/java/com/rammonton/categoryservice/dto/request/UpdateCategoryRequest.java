package com.rammonton.categoryservice.dto.request;

import com.rammonton.categoryservice.enums.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateCategoryRequest {

    @NotBlank(message = "Category name is required")
    @Size(max = 100)
    private String name;

    @NotNull(message = "Category type is required")
    private CategoryType type;

    @Size(max = 100)
    private String icon;

    @Size(max = 20)
    private String color;

    @Size(max = 255)
    private String description;

    @NotNull
    private Boolean active;
}