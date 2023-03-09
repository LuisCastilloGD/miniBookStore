package com.grid.BookStore.services.implementations;

import com.grid.BookStore.converters.BookMapper;
import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.exception.BookNotFoundedException;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.repositories.BookRepository;
import com.grid.BookStore.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public BookDto addBook(final Book book) {
        return bookMapper.modelToDto(bookRepository.save(book));
    }

    @Override
    public BookDto getBook(final Long id) {
        return bookRepository.findById(id)
                             .map(bookMapper::modelToDto)
                             .orElseThrow(() -> new BookNotFoundedException(id));
    }


    @Override
    public BookDto editBook(final Long id, final Book book) {
        return bookRepository.findById(id)
                            .map(foundedBook -> {
                                book.setId(foundedBook.getId());
                                return bookRepository.save(book);
                            })
                             .map(bookMapper::modelToDto)
                             .orElseThrow(() -> new BookNotFoundedException(id));
    }

    @Override
    public void deleteBook(final Long id) {
        bookRepository.findById(id)
                         .ifPresentOrElse(book -> bookRepository.deleteById(id),

                                          () -> {
                                              throw new BookNotFoundedException(id);
                                            });
    }
}
