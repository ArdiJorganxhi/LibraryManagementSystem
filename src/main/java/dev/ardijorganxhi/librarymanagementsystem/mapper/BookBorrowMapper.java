package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import org.springframework.stereotype.Component;

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
}
