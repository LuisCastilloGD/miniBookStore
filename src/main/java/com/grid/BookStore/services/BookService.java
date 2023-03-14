package com.grid.BookStore.services;

import com.grid.BookStore.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book addBook(Book book);

    Book getBook(Long id);

    Book getBookByTitle(String title);

    Book editBook(Long id, Book book);

    void deleteBook(Long id);

    List<Book> findByAuthor(String name);

    List<Book> findAllBooksFromAuthorsPage(Long id);
}
