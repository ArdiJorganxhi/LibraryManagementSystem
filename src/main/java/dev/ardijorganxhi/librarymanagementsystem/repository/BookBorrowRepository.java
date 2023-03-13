package dev.ardijorganxhi.librarymanagementsystem.repository;

import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {

    BookBorrow findByBookIdAndUserId(Long bookId, Long userId);
    Long countByUserId(Long userId);
}
