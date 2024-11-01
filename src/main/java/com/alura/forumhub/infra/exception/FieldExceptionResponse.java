package com.alura.forumhub.infra.exception;

import org.springframework.validation.FieldError;

public record FieldExceptionResponse(String field, String message) {

    public FieldExceptionResponse(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
