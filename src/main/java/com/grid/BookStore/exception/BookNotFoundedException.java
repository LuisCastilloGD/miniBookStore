package com.grid.BookStore.exception;

public class BookNotFoundedException extends RuntimeException {

    public BookNotFoundedException() {
        super("Book not found");
    }
}
