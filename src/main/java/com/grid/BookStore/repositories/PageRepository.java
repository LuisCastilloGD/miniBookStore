package com.grid.BookStore.repositories;

import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageRepository extends CrudRepository<Page, Long> {
    @Query(nativeQuery = true, value = "SELECT * " +
                                       "FROM page " +
                                       "WHERE id IN " +
                                       "(" +
                                       "SELECT pages_id " +
                                       "    FROM " +
                                       "book_pages AS bp join " +
                                       "        book_authors AS ba ON bp.book_id=ba.book_id JOIN" +
                                       "        author ON authors_id=id " +
                                       "WHERE name= ?1)"  )
    List<Page> findPagesByAuthors_Name(@NonNull String authorName);

    @Query(nativeQuery = true, value = "SELECT * " +
                                       "FROM page " +
                                       "WHERE id IN " +
                                       "(" +
                                       "SELECT pages_id " +
                                       "    FROM " +
                                       "book_pages AS bp join " +
                                       "        book_authors AS ba ON bp.book_id=ba.book_id JOIN" +
                                       "        author ON authors_id=id " +
                                       "WHERE name= ?1) limit ?2 "  )
    List<Page> findNPagesByAuthors_Name(@NonNull String authorName ,@Positive Long n);
}
