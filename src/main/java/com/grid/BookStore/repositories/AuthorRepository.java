package com.grid.BookStore.repositories;

import com.grid.BookStore.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("select a from Author a where a.name = ?1")
    Optional<Author> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM author " +
           "WHERE id IN(" +
           "" +
           "SELECT authors_id FROM " +
           "book_authors AS ba JOIN  " +
           "        book_pages AS bp ON bp.book_id=ba.book_id JOIN " +
           "page ON pages_id = id" +
           "    WHERE id = ?1" +
           ")")
    List<Author> findAuthorsByPageId(Long id);

}
