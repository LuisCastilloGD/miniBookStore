package com.grid.BookStore.controllers;

import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.dtos.PageDto;
import com.grid.BookStore.services.PageService;
import com.grid.BookStore.services.implementations.BookFacade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/mini_store/pages")
public class PageController {

    private final BookFacade bookFacade;

    @PostMapping("/add")
    public PageDto addPage(@Valid @RequestBody Page page){
        return bookFacade.addPage(page);
    }

    @GetMapping("/get/{id}")
    public PageDto getPage(@PathVariable("id") Long id){
        return bookFacade.getPage(id);
    }

    @PutMapping("/edit/{id}")
    public PageDto editPage(@PathVariable("id") Long id, @Valid @RequestBody Page page){
        return bookFacade.editPage(id,page);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePage(@PathVariable("id") Long id){
        bookFacade.deletePage(id);
    }

    @GetMapping("/get_n_by_author_name/{name}")
    public List<PageDto> getNPagesByAuthorName(@PathVariable("name") String name,
                                               @Min(0) @RequestParam(value = "n", required = false) Long n){
        return Optional.ofNullable(n)
                .map(limit -> bookFacade.getNPagesByAuthorName(name, limit))
                .orElse(bookFacade.getPagesByAuthorName(name));
    }

}
