package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
