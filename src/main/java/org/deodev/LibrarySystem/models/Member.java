package org.deodev.LibrarySystem.models;

import org.deodev.LibrarySystem.enums.Role;

import java.time.LocalDateTime;


public class Member {
    private String name;
    private static int idCount = 1;
    private int id;
    private Role role;
    private LocalDateTime lastBookRequestTime;

    public Member(String name, Role role) {
        this.name = name;
        id = idCount;
        idCount++;
        this.role = role;
    }

    // !!! Update methods

    public LocalDateTime getRequestTime() {
        return LocalDateTime.of(2024, 4, 5, 10, 30);
    }

    public int getRole() {
        return 1;
    }
}
