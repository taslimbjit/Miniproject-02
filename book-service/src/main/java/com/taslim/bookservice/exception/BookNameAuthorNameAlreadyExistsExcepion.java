package com.taslim.bookservice.exception;

public class BookNameAuthorNameAlreadyExistsExcepion extends RuntimeException{
    public BookNameAuthorNameAlreadyExistsExcepion(String message) {
        super(message);
    }
}
