package com.grid.BookStore.exception.advisors;

import com.grid.BookStore.exception.PageNotFoundedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PageNotFoundedAdvise {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PageNotFoundedException.class)
    public String pageNotFoundHandler(final PageNotFoundedException e) {
        return e.getMessage();
    }


}
