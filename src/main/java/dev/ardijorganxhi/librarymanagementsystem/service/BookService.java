package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.mapper.BookMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterBookRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book registerBook(RegisterBookRequest request){
        Book book = bookMapper.registerBook(request);
        bookRepository.save(book);
        return book;
    }
    public List<BookDto> getBooks(){
        return bookMapper.listToDto(bookRepository.findAll());
    }
    public BookDto getBookById(Long id){
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow());
    }
    public void deleteBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }

    public List<String> getBooksByAuthor(String author){
        return bookRepository.findByAuthor(author.toUpperCase());
    }
    public List<String> getAuthors(){
        return bookRepository.getAllAuthors();
    }

}
