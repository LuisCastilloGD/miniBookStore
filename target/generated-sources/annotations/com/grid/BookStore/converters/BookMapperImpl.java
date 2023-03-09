package com.grid.BookStore.converters;

import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.dtos.BookDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T16:39:53-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto modelToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setAuthor( book.getAuthor() );
        bookDto.setPrice( book.getPrice() );
        bookDto.setStock( book.getStock() );

        return bookDto;
    }

    @Override
    public Book dtoToModel(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setAuthor( bookDto.getAuthor() );
        book.setPrice( bookDto.getPrice() );
        book.setStock( bookDto.getStock() );

        return book;
    }
}
