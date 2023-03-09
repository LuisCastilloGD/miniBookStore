package com.grid.BookStore.converters;

import com.grid.BookStore.dtos.BookDto;
import com.grid.BookStore.models.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoConverter implements Converter<Book, BookDto> {
    @Override
    public BookDto convert(final Book book) {
        return BookDto.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .stock(book.getStock())
                      .build();
    }
}
