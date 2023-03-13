package dev.ardijorganxhi.librarymanagementsystem.controller;


import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.service.BookBorrowService;
import dev.ardijorganxhi.librarymanagementsystem.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookBorrowService bookBorrowService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PostMapping("/{userId}/book/{bookId}")
    public ResponseEntity<BookBorrow> borrowBook(@PathVariable Long userId, @PathVariable Long bookId, @RequestBody BookBorrowRequest request) throws Exception{
        return ResponseEntity.ok(bookBorrowService.borrowBook(bookId, userId, request));
    }
    @DeleteMapping("/{userId}/book/{bookId}")
    public void returnBook(@PathVariable Long userId, @PathVariable Long bookId){
        bookBorrowService.returnBook(bookId, userId);
    }
    @PostMapping("/{id}/subscribe-monthly")
    public ResponseEntity<Subscription> registerMonthly(@PathVariable Long id, @RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(userService.registerMonthly(id, request));
    }
    @PostMapping("/{id}/subscribe-yearly")
    public ResponseEntity<Subscription> registerYearly(@PathVariable Long id, @RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(userService.registerYearly(id, request));
    }
    @DeleteMapping("/{id}/unsubscribe")
    public void deleteSubscription(@PathVariable Long id) throws Exception{
        userService.deleteSubscription(id);
    }



}
