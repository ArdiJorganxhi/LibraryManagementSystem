package dev.ardijorganxhi.librarymanagementsystem.repository;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.name FROM Book b WHERE b.author = ?1")
    List<String> findByAuthor(String author);

    @Query("SELECT DISTINCT b.author FROM Book b")
    List<String> getAllAuthors();
}
