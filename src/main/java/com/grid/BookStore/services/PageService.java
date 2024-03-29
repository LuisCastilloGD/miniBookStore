package com.grid.BookStore.services;

import com.grid.BookStore.models.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PageService {

    Page addPage(Page page);

    Page getPage(Long id);

    Page editPage(Long id, Page page);

    void deletePage(Long id);

    List<Page> findPagesByAuthor(String name);

    List<Page> findNPagesByAuthor(String name, Long n);
}
