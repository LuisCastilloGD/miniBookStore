package com.grid.BookStore.converters;

import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.AuthorDto;
import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.dtos.PageDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T14:44:54-0600",
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
        bookDto.setAuthors( authorListToAuthorDtoList( book.getAuthors() ) );
        bookDto.setPages( pageListToPageDtoList( book.getPages() ) );
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
        book.setAuthors( authorDtoListToAuthorList( bookDto.getAuthors() ) );
        book.setPages( pageDtoListToPageList( bookDto.getPages() ) );
        book.setPrice( bookDto.getPrice() );
        book.setStock( bookDto.getStock() );

        return book;
    }

    protected AuthorDto authorToAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );

        return authorDto;
    }

    protected List<AuthorDto> authorListToAuthorDtoList(List<Author> list) {
        if ( list == null ) {
            return null;
        }

        List<AuthorDto> list1 = new ArrayList<AuthorDto>( list.size() );
        for ( Author author : list ) {
            list1.add( authorToAuthorDto( author ) );
        }

        return list1;
    }

    protected PageDto pageToPageDto(Page page) {
        if ( page == null ) {
            return null;
        }

        String content = null;
        Integer number = null;

        content = page.getContent();
        number = page.getNumber();

        PageDto pageDto = new PageDto( content, number );

        pageDto.setId( page.getId() );

        return pageDto;
    }

    protected List<PageDto> pageListToPageDtoList(List<Page> list) {
        if ( list == null ) {
            return null;
        }

        List<PageDto> list1 = new ArrayList<PageDto>( list.size() );
        for ( Page page : list ) {
            list1.add( pageToPageDto( page ) );
        }

        return list1;
    }

    protected Author authorDtoToAuthor(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDto.getId() );
        author.setName( authorDto.getName() );

        return author;
    }

    protected List<Author> authorDtoListToAuthorList(List<AuthorDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Author> list1 = new ArrayList<Author>( list.size() );
        for ( AuthorDto authorDto : list ) {
            list1.add( authorDtoToAuthor( authorDto ) );
        }

        return list1;
    }

    protected Page pageDtoToPage(PageDto pageDto) {
        if ( pageDto == null ) {
            return null;
        }

        Page page = new Page();

        page.setId( pageDto.getId() );
        page.setContent( pageDto.getContent() );
        page.setNumber( pageDto.getNumber() );

        return page;
    }

    protected List<Page> pageDtoListToPageList(List<PageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Page> list1 = new ArrayList<Page>( list.size() );
        for ( PageDto pageDto : list ) {
            list1.add( pageDtoToPage( pageDto ) );
        }

        return list1;
    }
}
