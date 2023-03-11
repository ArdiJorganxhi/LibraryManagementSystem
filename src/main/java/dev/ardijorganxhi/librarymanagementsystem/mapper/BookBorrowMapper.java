package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import org.springframework.stereotype.Component;

@Component
public class BookBorrowMapper {

    public BookBorrow borrowBook(Long id, User user, BookBorrowRequest request){
        return BookBorrow.builder()
                .bookId(id)
                .borrowDate(request.getBorrowDate())
                .returnDate(request.getReturnDate())
                .user(user)
                .build();
    }
}
