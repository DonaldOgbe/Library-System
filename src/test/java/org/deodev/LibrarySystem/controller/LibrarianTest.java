package org.deodev.LibrarySystem.controller;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.*;
import org.deodev.LibrarySystem.util.HierarchyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Librarian testLibrarian;
    Library testLibrary;
    Book testBook;
    HierarchyQueue testHierarchyQueue;
    Member testMember;



    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
        testLibrarian = new Librarian();
        testLibrary = new Library();
        testBook = new Book("Dream Count", 1);
        testHierarchyQueue = new HierarchyQueue();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void addBookToLibrary() {
        testLibrarian.addBook(testBook, testLibrary);
        boolean result = testLibrary.containsBook(testBook.getBookTitle());
        assertTrue(result);
    }

    @Test
    void addMemberBookRequestToQueue() {
        testMember = new Member("Amanda", Role.TEACHER);
        testLibrarian.addRequestToQueue(testHierarchyQueue, testMember);
        boolean result = testHierarchyQueue.peekNext().equals(testMember);
        assertTrue(result);
    }

    static Stream<Arguments> provideMembersForTesting() {
        return Stream.of(Arguments.of(new Teacher("Mark"), new JuniorStudent("Princess")),
                        Arguments.of(new SeniorStudent("Mary"), new JuniorStudent("Jerry")),
                        Arguments.of(new SeniorStudent("Mary"), new SeniorStudent("Jerry"))
                );
    }

    @ParameterizedTest
    @MethodSource("provideMembersForTesting")
    void processQueueAndPrintMessage(Member member1, Member member2) {
        testLibrarian.addRequestToQueue(testHierarchyQueue, member1);
        testLibrarian.addRequestToQueue(testHierarchyQueue, member2);
        testLibrary.addBook(testBook);

        String bookTitle = testBook.getBookTitle();
        String member1Name = member1.getName();
        String member2Name = member2.getName();

        testLibrarian.processQueue(testHierarchyQueue, testLibrary, testBook.getBookTitle());
        String expected = String.format("%s is issued to %s%nSorry %s there are no more copies of %s%n", bookTitle, member1Name, member2Name, bookTitle);
        assertEquals(expected.trim(), outputStream.toString().trim());
    }


}