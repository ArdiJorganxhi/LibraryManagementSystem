package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterBookRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
                .stock(request.getStock())
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

    public BookResponse toResponse(Page<Book> bookPage){
        return BookResponse.builder()
                .content(listToDto(bookPage.getContent()))
                .pageNo(bookPage.getNumber())
                .pageSize(bookPage.getSize())
                .totalPages(bookPage.getTotalPages())
                .totalElements(bookPage.getTotalElements())
                .last(bookPage.isLast())
                .build();
    }
}
