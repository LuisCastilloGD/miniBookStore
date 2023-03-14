package com.grid.BookStore.repositories;

import com.grid.BookStore.models.Book;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAuthors_Name(@NonNull String authorName);

    @Query(nativeQuery = true, value = "SELECT book.id,price,stock,title " +
                                       "FROM book " +
                                       "JOIN book_authors AS ba ON book.id = book_id  " +
                                       "JOIN author ON ba.authors_id= author.id WHERE author.id IN( " +
                                       "    SELECT authors_id FROM  " +
                                       "      book_authors AS ba JOIN  " +
                                       "        book_pages AS bp ON bp.book_id=ba.book_id JOIN " +
                                       "        page ON pages_id = id " +
                                       "    WHERE id = ?1" +
                                       ")")
    List<Book> findAllBooksFromAuthorsPage(Long id);
}
