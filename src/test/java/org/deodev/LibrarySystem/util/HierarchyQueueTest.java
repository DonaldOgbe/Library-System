package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void getHighestPriorityInQueue() {
        Member teacher = new Member("Amanda", Role.TEACHER);
        Member student = new Member("Chima", Role.SENIOR_STUDENT);

        testHierarchyQueue.addToQueue(student);
        testHierarchyQueue.addToQueue(teacher);

        Member result = testHierarchyQueue.getHighestPriority();
        assertTrue(result.equals(teacher));
    }

    @Test
    void getSizeOfQueue() {
        testHierarchyQueue.addToQueue(testMember);
        int result = testHierarchyQueue.size();
        assertEquals(1, result);
    }


}