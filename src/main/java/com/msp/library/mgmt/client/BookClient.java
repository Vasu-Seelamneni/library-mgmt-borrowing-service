package com.msp.library.mgmt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "library-mgmt-book-service")
public interface BookClient {

    @GetMapping("/api/books/available/{bookId}")
    Boolean isBookAvailable(@PathVariable("bookId") Long bookId);

    @PutMapping("/api/books/{bookId}")
    void updateBookAvailability(@PathVariable("bookId") Long bookId, @RequestParam("available") Boolean available);
}

