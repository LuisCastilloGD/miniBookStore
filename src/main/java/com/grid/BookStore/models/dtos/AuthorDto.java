package com.grid.BookStore.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;
}
