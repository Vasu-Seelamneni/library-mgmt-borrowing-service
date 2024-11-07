package com.msp.library.mgmt.service;

import com.msp.library.mgmt.model.Borrowing;

public interface BorrowingService {

    Borrowing borrowBook(Long userId, Long bookId);

    void returnBook(Long userId, Long bookId);

    Iterable<Borrowing> getUserBorrowingHistory(Long userId);

}
