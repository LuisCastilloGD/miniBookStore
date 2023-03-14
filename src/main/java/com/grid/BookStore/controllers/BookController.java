package com.grid.BookStore.controllers;

import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.services.BookService;
import com.grid.BookStore.services.implementations.BookFacade;
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

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mini_store/books")
public class BookController {

    private final BookFacade bookFacade;

    @PostMapping("/add")
    public BookDto addBook(@Valid @RequestBody Book book){
        return bookFacade.addBook(book);
    }

    @GetMapping("/get/{id}")
    public BookDto getBook(@PathVariable("id") Long id){
        return bookFacade.getBook(id);
    }

    @PutMapping("/edit/{id}")
    public BookDto editBook(@PathVariable("id") Long id, @Valid @RequestBody Book book){
        return bookFacade.editBook(id,book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookFacade.deleteBook(id);
    }

    @GetMapping("/get_by_author_name/{name}")
    public List<BookDto> getBooksByAuthorName(@PathVariable("name") String name){
        return bookFacade.getBooksByAuthorName(name);
    }

    @GetMapping("/get_from_authors_by_page_id/{id}")
    public List<BookDto> getBooksFromAuthorsPage(@PathVariable("id") Long id){
        return bookFacade.getAllBooksFromAuthorsPage(id);
    }

}
