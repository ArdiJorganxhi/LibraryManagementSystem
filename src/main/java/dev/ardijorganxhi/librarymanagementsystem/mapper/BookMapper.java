package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public Book registerBook(RegisterBookRequest request){
        return Book.builder()
                .name(request.getName())
                .author(request.getAuthor().toUpperCase())
                .page(request.getPage())
                .build();
    }

    public BookDto toDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .stock(book.getStock())
                .build();
    }

    public List<BookDto> listToDto(List<Book> books){
        return books.stream().map(this::toDto).collect(Collectors.toList());
    }
}
