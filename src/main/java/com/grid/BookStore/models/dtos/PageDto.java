package com.grid.BookStore.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class PageDto {

    @NotNull
    private Long id;

    @NotNull
    @NonNull
    @NotBlank
    private String content;

    @NonNull
    @NotNull
    private Integer number;
}
