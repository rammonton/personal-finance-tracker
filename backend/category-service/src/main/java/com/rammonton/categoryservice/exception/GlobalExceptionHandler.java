package com.rammonton.categoryservice.exception;

import com.rammonton.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryNotFound(
            CategoryNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ApiResponse.<Void>builder()
                                .success(false)
                                .message(ex.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(DuplicateCategoryException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicateCategory(
            DuplicateCategoryException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ApiResponse.<Void>builder()
                                .success(false)
                                .message(ex.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(
                        ApiResponse.<Void>builder()
                                .success(false)
                                .message(message)
                                .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.<Void>builder()
                                .success(false)
                                .message("Something went wrong.")
                                .build()
                );
    }
}