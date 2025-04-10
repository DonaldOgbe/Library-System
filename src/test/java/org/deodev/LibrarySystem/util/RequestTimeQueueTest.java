package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTimeQueueTest {
    Member testMember;
    BaseQueue testQueue;

    @BeforeEach
    void setup() {
        testMember = new Member("Teacher", Role.TEACHER);
        testQueue = new RequestTimeQueue();
    }

    @Test
    void addMemberToQueue() {
        testQueue.addToQueue(testMember);
        Member result = testQueue.peekNext();
        assertEquals("Teacher", result.getName());
    }

    @Test
    void checkMemberInQueue() {
        Member teacher = new Member("Teacher", Role.TEACHER);
        testQueue.addToQueue(teacher);
        Member result = testQueue.peekNext();
        assertEquals("Teacher", result.getName());
    }

    @Test
    void getHighestPriorityInQueue() {
        Member teacher = new Member("Teacher", Role.TEACHER);
        Member student = new Member("Student", Role.SENIOR_STUDENT);

        teacher.setLastBookRequestTime();
        student.setLastBookRequestTime();

        testQueue.addToQueue(teacher);
        testQueue.addToQueue(student);

        Member result = testQueue.getHighestInQueue();
        assertEquals("Teacher", result.getName());
    }

    @Test
    void getSizeOfQueue() {
        testQueue.addToQueue(testMember);
        int result = testQueue.size();
        assertEquals(1, result);
    }


}