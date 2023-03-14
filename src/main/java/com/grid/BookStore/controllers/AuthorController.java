package com.grid.BookStore.controllers;

import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.dtos.AuthorDto;
import com.grid.BookStore.models.dtos.PageDto;
import com.grid.BookStore.services.AuthorService;
import com.grid.BookStore.services.implementations.BookFacade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mini_store/authors")
public class AuthorController {

    private final BookFacade bookFacade;

    @PostMapping("/add")
    public AuthorDto addAuthor(@Valid @RequestBody Author author){
        return bookFacade.addAuthor(author);
    }

    @GetMapping("/get/{id}")
    public AuthorDto getAuthor(@PathVariable("id") Long id){
        return bookFacade.getAuthor(id);
    }

    @PutMapping("/edit/{id}")
    public AuthorDto editAuthor(@PathVariable("id") Long id, @Valid @RequestBody Author author){
        return bookFacade.editAuthor(id,author);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id){
        bookFacade.deleteAuthor(id);
    }

    @GetMapping("/get_by_page_id/{id}")
    public List<AuthorDto> getAuthorsFromPageId(@PathVariable("id") Long id){
        return bookFacade.getAuthorsByPageId(id);
    }
}
