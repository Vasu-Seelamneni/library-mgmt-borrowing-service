package com.msp.library.mgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "borrowings")
@Getter
@Setter
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long bookId;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnedDate;
    private LocalDateTime dueDate;

}
