package com.grid.BookStore.exception;

public class BookNotFoundedException extends RuntimeException{

    public BookNotFoundedException(Long bookId) {
        super(String.format("Book with id %s not found", bookId));
    }
}
