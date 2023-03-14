package com.grid.BookStore.exception.advisors;

import com.grid.BookStore.exception.AuthorNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AuthorNotFoundedAdvise {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AuthorNotFoundedException.class)
    public String authorNotFoundHandler(final AuthorNotFoundedException e) {
        return e.getMessage();
    }
}
