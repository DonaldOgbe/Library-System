package org.deo.dev.LibrarySystem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    String name;
    Member testMember;

    @BeforeEach
    void setup() {
        name = "Amanda";
        testMember = new Member(name, null);
    }

    @Test
    void getRequestTime() {
        LocalDateTime result = testMember.getRequestTime();
        assertEquals(LocalDateTime.of(2024, 4, 5, 10, 30), result);

    }

    @Test
    void getEnumRole() {
        int result = testMember.getRole();
        assertEquals(1, result);
    }
}