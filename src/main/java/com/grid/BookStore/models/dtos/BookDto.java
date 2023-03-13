package com.grid.BookStore.models.dtos;

import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.Page;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private List<Author> authors;

    @NotNull
    private List<Page> pages;

    @Positive
    private BigDecimal price;

    @Positive
    private Long stock;

}
