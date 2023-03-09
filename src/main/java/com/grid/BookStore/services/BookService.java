package com.grid.BookStore.services;

import com.grid.BookStore.dtos.BookDto;
import com.grid.BookStore.models.Book;
import org.springframework.stereotype.Service;


@Service
public interface BookService {

    BookDto addBook(Book book);
    BookDto getBook(Long id);
    BookDto editBook(Long id, Book book);
    void deleteBook(Long id);

}
