package com.msp.library.mgmt.controller;

import com.msp.library.mgmt.model.Borrowing;
import com.msp.library.mgmt.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping("/borrow/{userId}/{bookId}")
    public Borrowing borrowBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return borrowingService.borrowBook(userId, bookId);
    }

    @PutMapping("/return/{userId}/{bookId}")
    public void returnBook(@PathVariable Long userId, @PathVariable Long bookId) {
        borrowingService.returnBook(userId, bookId);
    }


}
