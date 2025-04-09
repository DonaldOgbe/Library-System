package org.deodev.LibrarySystem.controller;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.model.Library;
import org.deodev.LibrarySystem.model.Member;
import org.deodev.LibrarySystem.util.HierarchyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {
    Librarian testLibrarian;
    Library testLibrary;
    Book testBook;
    HierarchyQueue testHierarchyQueue;
    Member testMember;

    @BeforeEach
    void setup() {
        testLibrarian = new Librarian();
        testLibrary = new Library();
        testBook = new Book("Dream Count", 3);
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
        testHierarchyQueue = new HierarchyQueue();
        testLibrarian.addRequestToQueue(testHierarchyQueue, testMember);
        boolean result = testHierarchyQueue.peekNext().equals(testMember);
        assertTrue(result);
    }




}