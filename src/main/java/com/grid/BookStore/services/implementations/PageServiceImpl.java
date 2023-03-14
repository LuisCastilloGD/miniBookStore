package com.grid.BookStore.services.implementations;

import com.grid.BookStore.converters.PageMapper;
import com.grid.BookStore.exception.PageNotFoundedException;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.PageDto;
import com.grid.BookStore.repositories.PageRepository;
import com.grid.BookStore.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Override
    public Page addPage(final Page page) {
        return pageRepository.save(page);
    }

    @Override
    public Page getPage(final Long id) {
        return pageRepository.findById(id)
                             .orElseThrow(() -> new PageNotFoundedException(id));
    }


    @Override
    public Page editPage(final Long id, final Page page) {
        return pageRepository.findById(id)
                            .map(foundedPage -> {
                                page.setId(foundedPage.getId());
                                return pageRepository.save(page);
                            })
                             .orElseThrow(() -> new PageNotFoundedException(id));
    }

    @Override
    public void deletePage(final Long id) {
        pageRepository.findById(id)
                         .ifPresentOrElse(page -> pageRepository.deleteById(id),

                                          () -> {
                                              throw new PageNotFoundedException(id);
                                            });
    }

    @Override
    public List<Page> findPagesByAuthor(final String name){
        return pageRepository.findPagesByAuthors_Name(name).stream().toList();
    }

    @Override
    public List<Page> findNPagesByAuthor(final String name, Long n){
        return pageRepository.findNPagesByAuthors_Name(name,n).stream().toList();
    }
}
