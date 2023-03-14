package com.grid.BookStore.services.implementations;

import com.grid.BookStore.exception.BookNotFoundedException;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.repositories.BookRepository;
import com.grid.BookStore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(final Book book) {
        if (bookRepository.findByTitle(book.getTitle()).isPresent()) {
            return bookRepository.findByTitle(book.getTitle())
                                 .orElseThrow(() -> new BookNotFoundedException());
        } else {
            return bookRepository.save(book);
        }
    }

    @Override
    public Book getBook(final Long id) {
        return bookRepository.findById(id)
                             .orElseThrow(() -> new BookNotFoundedException());
    }

    @Override
    public Book getBookByTitle(final String title) {
        return bookRepository.findByTitle(title)
                             .orElseThrow(() -> new BookNotFoundedException());
    }

    @Override
    public Book editBook(final Long id, final Book book) {
        return bookRepository.findById(id)
                             .map(foundedBook -> {
                                 book.setId(foundedBook.getId());
                                 return bookRepository.save(book);
                             })
                             .orElseThrow(() -> new BookNotFoundedException());
    }

    @Override
    public void deleteBook(final Long id) {
        bookRepository.findById(id)
                      .ifPresentOrElse(book -> bookRepository.deleteById(id),

                                       () -> {
                                           throw new BookNotFoundedException();
                                       });
    }

    @Override
    public List<Book> findByAuthor(final String name) {
        return bookRepository.findByAuthors_Name(name).stream().toList();
    }

    @Override
    public List<Book> findAllBooksFromAuthorsPage(final Long id) {
        return bookRepository.findAllBooksFromAuthorsPage(id);
    }
}
