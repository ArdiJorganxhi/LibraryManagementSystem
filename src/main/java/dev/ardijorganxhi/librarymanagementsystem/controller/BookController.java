package dev.ardijorganxhi.librarymanagementsystem.controller;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterBookRequest;
import dev.ardijorganxhi.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody RegisterBookRequest request){
        return ResponseEntity.ok(bookService.registerBook(request));
    }
    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<String>> getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }
}
