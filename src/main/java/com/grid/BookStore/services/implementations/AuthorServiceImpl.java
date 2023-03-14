package com.grid.BookStore.services.implementations;

import com.grid.BookStore.converters.AuthorMapper;

import com.grid.BookStore.exception.AuthorNotFoundedException;
import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.dtos.AuthorDto;
import com.grid.BookStore.repositories.AuthorRepository;
import com.grid.BookStore.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Author addAuthor(final Author author) {
        if(authorRepository.findByName(author.getName()).isPresent()){
            return authorRepository.findByName(author.getName())
                                   .orElseThrow(() -> new AuthorNotFoundedException());
        }else{
            return authorRepository.save(author);
        }
    }

    @Override
    public Author getAuthor(final Long id) {
        return authorRepository.findById(id)
                             .orElseThrow(() -> new AuthorNotFoundedException());
    }
    @Override
    public Author getAuthorByName(final String name) {
        return authorRepository.findByName(name)
                               .orElseThrow(() -> new AuthorNotFoundedException());
    }


    @Override
    public Author editAuthor(final Long id, final Author author) {
        return authorRepository.findById(id)
                            .map(foundedAuthor -> {
                                author.setId(foundedAuthor.getId());
                                return authorRepository.save(author);
                            })
                             .orElseThrow(() -> new AuthorNotFoundedException());
    }

    @Override
    public void deleteAuthor(final Long id) {
        authorRepository.findById(id)
                         .ifPresentOrElse(author -> authorRepository.deleteById(id),

                                          () -> {
                                              throw new AuthorNotFoundedException();
                                            });
    }

    @Override
    public List<Author> findAuthorsByPageId(final Long id) {
        return authorRepository.findAuthorsByPageId(id);
    }
}
