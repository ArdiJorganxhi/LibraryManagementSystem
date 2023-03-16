package dev.ardijorganxhi.librarymanagementsystem.controller;


import dev.ardijorganxhi.librarymanagementsystem.entity.BookBorrow;
import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookBorrowDto;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.SubscriptionDto;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.BookBorrowRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterSubscriptionRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookBorrowResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.SubscriptionResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.UserResponse;
import dev.ardijorganxhi.librarymanagementsystem.service.BookBorrowService;
import dev.ardijorganxhi.librarymanagementsystem.service.SubscriptionService;
import dev.ardijorganxhi.librarymanagementsystem.service.UserService;
import dev.ardijorganxhi.librarymanagementsystem.utils.AppConstants;
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
    private final SubscriptionService subscriptionService;


    @GetMapping
    public UserResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return userService.findAllUsers(pageNo, pageSize, sortBy, sortDir);
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
    public ResponseEntity<BookBorrowDto> borrowBook(@PathVariable Long userId, @PathVariable Long bookId, @RequestBody BookBorrowRequest request) throws Exception{
        return ResponseEntity.ok(bookBorrowService.borrowBook(bookId, userId, request));
    }
    @DeleteMapping("/{userId}/book/{bookId}")
    public void returnBook(@PathVariable Long userId, @PathVariable Long bookId){
        bookBorrowService.returnBook(bookId, userId);
    }
    @GetMapping("/subscriptions")
    public SubscriptionResponse getAllSubscriptions(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return subscriptionService.getAllSubscriptions(pageNo, pageSize, sortBy, sortDir);
    }



    @PostMapping("/{id}/subscribe-monthly")
    public ResponseEntity<SubscriptionDto> registerMonthly(@PathVariable Long id, @RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(subscriptionService.registerMonthly(id, request));
    }
    @PostMapping("/{id}/subscribe-yearly")
    public ResponseEntity<SubscriptionDto> registerYearly(@PathVariable Long id, @RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(subscriptionService.registerYearly(id, request));
    }
    @DeleteMapping("/{id}/unsubscribe")
    public void deleteSubscription(@PathVariable Long id) throws Exception{
        subscriptionService.deleteSubscription(id);
    }



}
