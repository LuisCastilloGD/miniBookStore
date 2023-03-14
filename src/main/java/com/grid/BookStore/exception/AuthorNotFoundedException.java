package com.grid.BookStore.exception;

public class AuthorNotFoundedException extends RuntimeException {

    public AuthorNotFoundedException() {
        super("Author not found");
    }
}
