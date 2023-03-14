package com.grid.BookStore.services;

import com.grid.BookStore.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    Author addAuthor(Author author);

    Author getAuthor(Long id);

    Author getAuthorByName(String name);

    Author editAuthor(Long id, Author author);

    void deleteAuthor(Long id);

    List<Author> findAuthorsByPageId(Long id);
}
