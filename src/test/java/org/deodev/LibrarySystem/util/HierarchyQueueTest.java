package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HierarchyQueueTest {
    Member testMember;
    HierarchyQueue testHierarchyQueue;

    @BeforeEach
    void setup() {
        testMember = new Member("Amanda", Role.TEACHER);
        testHierarchyQueue = new HierarchyQueue();
    }

    @Test
    void addMemberToQueue() {
        testHierarchyQueue.addToQueue(testMember);
        Member result = testHierarchyQueue.peekNext();
        assertTrue(result.equals(testMember));
    }
}