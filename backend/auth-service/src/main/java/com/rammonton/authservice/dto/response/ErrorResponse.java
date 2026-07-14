package com.rammonton.authservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private boolean success;

    private String message;

    private LocalDateTime timestamp;

    /**
     * Validation errors
     *
     * Example:
     * {
     *   "email": "Email is required",
     *   "password": "Password must be at least 8 characters"
     * }
     */
    private Map<String, String> errors;

}