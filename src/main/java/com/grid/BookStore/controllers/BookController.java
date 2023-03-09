package com.grid.BookStore.controllers;

import com.grid.BookStore.dtos.BookDto;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/mini_store")
public class BookController {

    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody final Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id")final Long id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BookDto> editBook(@PathVariable("id")final Long id, @Valid @RequestBody final Book book){
        return new ResponseEntity<>(bookService.editBook(id,book), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable("id")final Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
