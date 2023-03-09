package com.grid.BookStore.converters;

import com.grid.BookStore.dtos.BookDto;
import com.grid.BookStore.models.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToBookConverter implements Converter<BookDto, Book> {
    @Override
    public Book convert(final BookDto bookDto) {
        return Book.builder()
                    .id(bookDto.getId())
                    .title(bookDto.getTitle())
                    .author(bookDto.getAuthor())
                    .price(bookDto.getPrice())
                    .stock(bookDto.getStock())
                    .build();
    }

}
