package com.grid.BookStore.controllers;

import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mini_store")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public BookDto addBook(@Valid @RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/get/{id}")
    public BookDto getBook(@PathVariable("id") Long id){
        return bookService.getBook(id);
    }

    @PutMapping("/edit/{id}")
    public BookDto editBook(@PathVariable("id") Long id, @Valid @RequestBody Book book){
        return bookService.editBook(id,book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }

}
