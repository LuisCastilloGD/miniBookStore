package com.grid.BookStore.exception.advisors;

import com.grid.BookStore.exception.BookNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookNotFoundedAdvise {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundedException.class)
    public String bookNotFoundHandler(final BookNotFoundedException e) {
        return e.getMessage();
    }
}
