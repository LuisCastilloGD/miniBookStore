package com.grid.BookStore.exception;

public class PageNotFoundedException extends RuntimeException {

    public PageNotFoundedException(Long id) {
        super(String.format("Page with id %s not found", id));
    }
}
