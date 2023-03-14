package com.grid.BookStore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "book", schema="book_store")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @NotNull
    @NotBlank
    private String title;
    @NonNull
    @ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY)
    private List<Author> authors;

    @NonNull
    @OneToMany(targetEntity = Page.class, fetch = FetchType.LAZY)
    private List<Page> pages;

    @NonNull
    @NotNull
    private BigDecimal price;

    @NonNull
    @NotNull
    private Long stock;


}
