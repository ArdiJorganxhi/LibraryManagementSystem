package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.exception.APIException;
import dev.ardijorganxhi.librarymanagementsystem.mapper.BookBorrowMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookBorrowDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.ErrorEnum;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookBorrowResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import dev.ardijorganxhi.librarymanagementsystem.repository.BookBorrowRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.BookRepository;
import dev.ardijorganxhi.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookBorrowService {
    private final BookBorrowRepository bookBorrowRepository;
    private final BookBorrowMapper bookBorrowMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BookBorrowResponse getAllBookBorrows(int pageNo, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<BookBorrow> bookBorrows = bookBorrowRepository.findAll(pageable);
        return bookBorrowMapper.toResponse(bookBorrows);
    }

    public BookBorrowDto borrowBook(Long bookId, Long userId, BookBorrowRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new APIException(ErrorEnum.USER_NOT_REGISTERED));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new APIException(ErrorEnum.BOOK_NOT_REGISTERED));
        if(book.getStock() < 0){
            throw new APIException(ErrorEnum.BOOK_OUT_OF_STOCK);
        }
        if(user.getSubscription() == null && bookBorrowRepository.countByUserId(userId) > 3){
            throw new APIException(ErrorEnum.VALIDATION_ERROR);
        }
        BookBorrow bookBorrow = bookBorrowMapper.borrowBook(user, book, request);
        user.getBooks().add(bookBorrow);
        book.setStock(book.getStock() - 1);
        bookBorrowRepository.save(bookBorrow);
        return bookBorrowMapper.toDto(bookBorrow);

    }
    public void returnBook(Long bookId, Long userId) {
        BookBorrow bookBorrow = bookBorrowRepository.findByBookIdAndUserId(bookId, userId);
        bookBorrow.getBook().setStock(bookBorrow.getBook().getStock() + 1);
        bookBorrowRepository.delete(bookBorrow);
    }
}
