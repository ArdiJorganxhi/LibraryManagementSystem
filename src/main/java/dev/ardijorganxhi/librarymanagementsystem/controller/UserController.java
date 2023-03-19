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
import dev.ardijorganxhi.librarymanagementsystem.utils.MdcConstant;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookBorrowService bookBorrowService;
    private final SubscriptionService subscriptionService;


    @GetMapping("/list")
    public UserResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return userService.findAllUsers(pageNo, pageSize, sortBy, sortDir);
    }
    @GetMapping
    public ResponseEntity<UserDto> getUserById(){
        return ResponseEntity.ok(userService.getUserById(Long.valueOf(MDC.get(MdcConstant.X_USER_ID))));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PostMapping("/book/{bookId}")
    public ResponseEntity<BookBorrowDto> borrowBook(@PathVariable Long bookId, @RequestBody BookBorrowRequest request) throws Exception{
        return ResponseEntity.ok(bookBorrowService.borrowBook(bookId, Long.valueOf(MDC.get(MdcConstant.X_USER_ID)), request));
    }
    @DeleteMapping("book/{bookId}")
    public void returnBook(@PathVariable Long bookId){
        bookBorrowService.returnBook(bookId, Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
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



    @PostMapping("/subscribe-monthly")
    public ResponseEntity<SubscriptionDto> registerMonthly( @RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(subscriptionService.registerMonthly(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)), request));
    }
    @PostMapping("/subscribe-yearly")
    public ResponseEntity<SubscriptionDto> registerYearly(@RequestBody RegisterSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(subscriptionService.registerYearly(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)), request));
    }
    @PutMapping("/subscribe-monthly")
    public ResponseEntity<SubscriptionDto> renewMonthly() {
        return ResponseEntity.ok(subscriptionService.renewSubscriptionMonthly(Long.valueOf(MDC.get(MdcConstant.X_USER_ID))));
    }

    @PutMapping("/subscribe-yearly")
    public ResponseEntity<SubscriptionDto> renewYearly() {
        return ResponseEntity.ok(subscriptionService.renewSubscriptionYearly(Long.valueOf(MDC.get(MdcConstant.X_USER_ID))));
    }
    @DeleteMapping("/unsubscribe")
    public void deleteSubscription() throws Exception{
        subscriptionService.deleteSubscription(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
    }



}
