package com.grid.BookStore.converters;

import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.Page;
import com.grid.BookStore.models.dtos.BookDto;
import com.grid.BookStore.models.dtos.PageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PageMapper {
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class);
    PageDto modelToDto(Page page);
    Page dtoToModel(PageDto pageDto);

}
