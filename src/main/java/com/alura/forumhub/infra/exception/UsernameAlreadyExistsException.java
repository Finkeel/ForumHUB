package com.alura.forumhub.infra.exception;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
