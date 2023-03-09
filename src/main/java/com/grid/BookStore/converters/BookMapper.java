package com.grid.BookStore.converters;

import com.grid.BookStore.models.Book;
import com.grid.BookStore.dtos.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDto modelToDto(Book book);
    Book dtoToModel(BookDto bookDto);
}