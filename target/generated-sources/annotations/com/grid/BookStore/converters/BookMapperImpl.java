package com.grid.BookStore.converters;

import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.BookDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T11:27:53-0600",
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
        List<Author> list = book.getAuthors();
        if ( list != null ) {
            bookDto.setAuthors( new ArrayList<Author>( list ) );
        }
        List<Page> list1 = book.getPages();
        if ( list1 != null ) {
            bookDto.setPages( new ArrayList<Page>( list1 ) );
        }
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
        List<Author> list = bookDto.getAuthors();
        if ( list != null ) {
            book.setAuthors( new ArrayList<Author>( list ) );
        }
        List<Page> list1 = bookDto.getPages();
        if ( list1 != null ) {
            book.setPages( new ArrayList<Page>( list1 ) );
        }
        book.setPrice( bookDto.getPrice() );
        book.setStock( bookDto.getStock() );

        return book;
    }
}
