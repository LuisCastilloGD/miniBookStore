package com.grid.BookStore.converters;

import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.dtos.BookDto.BookDtoBuilder;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Book.BookBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T15:18:57-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto modelToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoBuilder bookDto = BookDto.builder();

        bookDto.id( book.getId() );
        bookDto.title( book.getTitle() );
        bookDto.author( book.getAuthor() );
        bookDto.price( book.getPrice() );
        bookDto.stock( book.getStock() );

        return bookDto.build();
    }

    @Override
    public Book dtoToModel(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        BookBuilder book = Book.builder();

        book.id( bookDto.getId() );
        book.title( bookDto.getTitle() );
        book.author( bookDto.getAuthor() );
        book.price( bookDto.getPrice() );
        book.stock( bookDto.getStock() );

        return book.build();
    }
}
