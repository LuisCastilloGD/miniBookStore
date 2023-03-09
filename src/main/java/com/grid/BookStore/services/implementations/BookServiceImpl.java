package com.grid.BookStore.services.implementations;

import com.grid.BookStore.converters.BookToBookDtoConverter;
import com.grid.BookStore.dtos.BookDto;
import com.grid.BookStore.exception.BookNotFoundedException;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.repositories.BookRepository;
import com.grid.BookStore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookToBookDtoConverter bookToBookDtoConverter;

    @Override
    public BookDto addBook(final Book book) {
        return bookToBookDtoConverter.convert(bookRepository.save(book));
    }

    @Override
    public BookDto getBook(final Long id) {
        return bookRepository.findById(id)
                             .map(bookToBookDtoConverter::convert)
                             .orElseThrow(() -> new BookNotFoundedException(id));
    }


    @Override
    public BookDto editBook(final Long id, final Book book) {
        return bookRepository.findById(id)
                            .map(foundedBook -> {
                                book.setId(foundedBook.getId());
                                return bookRepository.save(book);
                            })
                             .map(bookToBookDtoConverter::convert)
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
