package com.grid.BookStore.converters;

import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.PageDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-14T00:07:22-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
)
@Component
public class PageMapperImpl implements PageMapper {

    @Override
    public PageDto modelToDto(Page page) {
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

    @Override
    public Page dtoToModel(PageDto pageDto) {
        if ( pageDto == null ) {
            return null;
        }

        Page page = new Page();

        page.setId( pageDto.getId() );
        page.setContent( pageDto.getContent() );
        page.setNumber( pageDto.getNumber() );

        return page;
    }
}
