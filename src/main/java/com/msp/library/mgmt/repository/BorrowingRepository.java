package com.msp.library.mgmt.repository;

import com.msp.library.mgmt.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    List<Borrowing> findByUserId(Long userId);
    Optional<Borrowing> findByUserIdAndBookIdAndReturnedDateIsNull(Long userId, Long bookId);
}
