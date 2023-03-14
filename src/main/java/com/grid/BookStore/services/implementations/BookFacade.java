package com.grid.BookStore.services.implementations;

import com.grid.BookStore.converters.AuthorMapper;
import com.grid.BookStore.converters.BookMapper;
import com.grid.BookStore.converters.PageMapper;
import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.AuthorDto;
import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.dtos.PageDto;
import com.grid.BookStore.repositories.BookRepository;
import com.grid.BookStore.services.AuthorService;
import com.grid.BookStore.services.BookService;
import com.grid.BookStore.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookFacade {

    private final BookService bookService;

    private final BookMapper bookMapper;

    private final AuthorService authorService;

    private final AuthorMapper authorMapper;

    private final PageService pageService;

    private final PageMapper pageMapper;

    //Books CRUD
    public BookDto addBook(Book book){

        List<Author> authors =book.getAuthors()
                                  .stream()
                                  .map(author -> authorService.addAuthor(author))
                                  .toList();

        book.setAuthors(authors);

        List<Page> pages = book.getPages()
                               .stream()
                               .map(page -> pageService.addPage(page))
                               .toList();

        book.setPages(pages);

        return bookMapper.modelToDto(bookService.addBook(book));
    }

    public BookDto getBook(Long id){

        return bookMapper.modelToDto(bookService.getBook(id));
    }
    public BookDto editBook(Long id, Book book){

        return bookMapper.modelToDto(bookService.editBook(id,book));
    }

    public void deleteBook(Long id){

        bookService.deleteBook(id);
    }

    //Author CRUD
    public AuthorDto addAuthor(Author author){

        return authorMapper.modelToDto(authorService.addAuthor(author));
    }

    public AuthorDto getAuthor(Long id){
        return  authorMapper.modelToDto(authorService.getAuthor(id));
    }

    public AuthorDto editAuthor(Long id, Author author){
        return  authorMapper.modelToDto(authorService.editAuthor(id,author));
    }
    public void deleteAuthor(Long id){
        authorService.deleteAuthor(id);
    }

    //Pages CRUD
    public PageDto addPage(Page page){

        return pageMapper.modelToDto(pageService.addPage(page));
    }

    public PageDto getPage(Long id){
        return  pageMapper.modelToDto(pageService.getPage(id));
    }

    public PageDto editPage(Long id, Page page){
        return  pageMapper.modelToDto(pageService.editPage(id,page));
    }
    public void deletePage(Long id){
        pageService.deletePage(id);
    }


    //QUERIES
    public List<BookDto> getBooksByAuthorName(String name){
        return bookService.findByAuthor(name).stream().map(bookMapper::modelToDto).toList();
    }

    public List<PageDto> getPagesByAuthorName(String name){
        return pageService.findPagesByAuthor(name).stream().map(pageMapper::modelToDto).toList();
    }

    public List<PageDto> getNPagesByAuthorName(String name, Long n){
        return pageService.findNPagesByAuthor(name,n).stream().map(pageMapper::modelToDto).toList();
    }

    public List<AuthorDto> getAuthorsByPageId(Long id){
        return authorService.findAuthorsByPageId(id).stream().map(authorMapper::modelToDto).toList();
    }

    public List<BookDto> getAllBooksFromAuthorsPage(Long id){
        return bookService.findAllBooksFromAuthorsPage(id).stream().map(bookMapper::modelToDto).toList();
    }

}
