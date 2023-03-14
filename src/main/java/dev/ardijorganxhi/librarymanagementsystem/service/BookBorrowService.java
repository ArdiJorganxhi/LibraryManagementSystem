package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.mapper.BookBorrowMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.BookBorrowRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.BookRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowService {
    private final BookBorrowRepository bookBorrowRepository;
    private final BookBorrowMapper bookBorrowMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BookBorrow borrowBook(Long bookId, Long userId, BookBorrowRequest request) throws Exception{
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found!"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new Exception("Book not found!"));
        BookBorrow bookBorrow = bookBorrowMapper.borrowBook(user, book, request);
        user.getBooks().add(bookBorrow);
        bookBorrowRepository.save(bookBorrow);
        return bookBorrow;

    }
    public void returnBook(Long bookId, Long userId){
        BookBorrow bookBorrow = bookBorrowRepository.findByBookIdAndUserId(bookId, userId);
        bookBorrowRepository.delete(bookBorrow);
    }
}
