package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookBorrowDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookBorrowMapper {

    public BookBorrow borrowBook(User user, Book book, BookBorrowRequest request){
        BookBorrow bookBorrow = new BookBorrow();
        bookBorrow.setBook(book);
        bookBorrow.setUser(user);
        bookBorrow.setBorrowDate(request.getBorrowDate());
        bookBorrow.setReturnDate(request.getReturnDate());
        return bookBorrow;
    }
    public BookBorrowDto toDto(BookBorrow bookBorrow){
        return BookBorrowDto.builder()
                .user(bookBorrow.getUser().getName())
                .book(bookBorrow.getBook().getName())
                .borrowDate(bookBorrow.getBorrowDate())
                .returnDate(bookBorrow.getReturnDate())
                .build();
    }

    public List<BookBorrowDto> listToDto(List<BookBorrow> bookBorrows){
        return bookBorrows.stream().map(this::toDto).collect(Collectors.toList());
    }
}
