package org.deodev.LibrarySystem.model;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.validation.InputValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Member {
    private String name;
    private static int idCount = 1;
    private int id;
    private Role role;
    private LocalDateTime lastBookRequestTime;
    private final ArrayList<String> borrowedBooks = new ArrayList<>();

    public Member(String name, Role role) {
        InputValidator.validateNotNullOrBlank(name);
        this.name = name;
        id = idCount;
        idCount++;
        this.role = role;
    }

    // !!! Update methods

    public LocalDateTime getRequestTime() {
        return lastBookRequestTime;
    }

    public Role getRole() {
        return role;
    }

    public void setLastBookRequestTime() {
        lastBookRequestTime = LocalDateTime.now();
    }

    public void borrowBook(String bookTitle) {
        InputValidator.validateNotNullOrBlank(bookTitle);
        borrowedBooks.add(bookTitle);
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }
}
