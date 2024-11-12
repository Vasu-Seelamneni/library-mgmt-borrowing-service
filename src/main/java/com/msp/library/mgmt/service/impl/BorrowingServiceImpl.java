package com.msp.library.mgmt.service.impl;

import com.msp.library.mgmt.client.BookClient;
import com.msp.library.mgmt.client.UserClient;
import com.msp.library.mgmt.model.Borrowing;
import com.msp.library.mgmt.repository.BorrowingRepository;
import com.msp.library.mgmt.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    /*@Autowired
    private BookClient bookClient;

    @Autowired
    private UserClient userClient;*/

    @Autowired
    private RestTemplate restTemplate;

    @Value("${library-mgmt-book-service.url}")
    private String bookServiceUrl;

    @Value("${library-mgmt-user-service.url}")
    private String userServiceUrl;

    @Override
    public Borrowing borrowBook(Long userId, Long bookId) {

        // Validate user and book availability
        /*String userExistsUrl = userServiceUrl + "/api/users/exists/" + userId;
        Boolean userExists = restTemplate.getForObject(userExistsUrl, Boolean.class);
        if(userExists != null && !userExists) {
            throw new RuntimeException("User not found");
        }

        String bookExistsUrl = bookServiceUrl + "/api/books/available/" + bookId;
        Boolean bookExists = restTemplate.getForObject(bookExistsUrl, Boolean.class);
        if(bookExists != null && !bookExists) {
            throw new RuntimeException("Book not available");
        }*/

        Borrowing borrowing = new Borrowing();
        borrowing.setUserId(userId);
        borrowing.setBookId(bookId);
        borrowing.setBorrowedDate(LocalDateTime.now());
        borrowing.setDueDate(LocalDateTime.now().plusDays(14));  // 2-week due date
        borrowingRepository.save(borrowing);

        // Update book availability
        String updateBookAvailabilityUrl = bookServiceUrl + "/api/books/" + bookId + "?available=false";
        restTemplate.put(updateBookAvailabilityUrl, null);

        return borrowing;
    }

    @Override
    public void returnBook(Long userId, Long bookId) {

        Borrowing borrowing = borrowingRepository.findByUserIdAndBookIdAndReturnedDateIsNull(userId, bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        borrowing.setReturnedDate(LocalDateTime.now());
        borrowingRepository.save(borrowing);

        // Update book availability
        String updateBookAvailabilityUrl = bookServiceUrl + "/api/books/" + bookId + "?available=true";
        restTemplate.put(updateBookAvailabilityUrl, null);

    }

    @Override
    public Iterable<Borrowing> getUserBorrowingHistory(Long userId) {
        return borrowingRepository.findByUserId(userId);
    }
}
