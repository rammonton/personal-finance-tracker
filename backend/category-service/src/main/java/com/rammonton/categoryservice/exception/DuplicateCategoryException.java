package com.rammonton.categoryservice.exception;

public class DuplicateCategoryException extends RuntimeException {

    public DuplicateCategoryException(String name) {
        super("Category already exists: " + name);
    }

}