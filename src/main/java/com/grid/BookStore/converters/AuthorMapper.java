package com.grid.BookStore.converters;

import com.grid.BookStore.models.Author;
import com.grid.BookStore.models.Book;
import com.grid.BookStore.models.dtos.AuthorDto;
import com.grid.BookStore.models.dtos.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    AuthorDto modelToDto(Author author);
    Author dtoToModel(AuthorDto authorDto);
}
