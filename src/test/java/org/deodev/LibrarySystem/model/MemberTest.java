package org.deodev.LibrarySystem.model;

import jdk.jfr.Description;
import org.deodev.LibrarySystem.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    String name;
    Member testMember;

    @BeforeEach
    void setup() {
        name = "Teacher";
        testMember = new Member(name, Role.TEACHER);
    }

    @Test
    void getEnumRole() {
        Role result = testMember.getRole();
        assertEquals(Role.TEACHER, result);
    }

    @Test
    void changeBookRequestTime() {
        testMember.setLastBookRequestTime();
        boolean result = testMember.getRequestTime() != null;
        assertTrue(result);
    }

    @Test
    void addBorrowedBookToList() {
        testMember.borrowBook("Book");
        boolean result = testMember.getBorrowedBooks().contains("Book");
        assertTrue(result);
    }

    @Test
    void getName() {
        String result = testMember.getName();
        assertEquals("Teacher", result);
    }
}