package com.grid.BookStore.models.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AuthorDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

//    private List<BookDto> books;

}
