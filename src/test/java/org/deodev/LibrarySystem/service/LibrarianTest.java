package org.deodev.LibrarySystem.service;

import org.deodev.LibrarySystem.enums.Role;
import org.deodev.LibrarySystem.model.*;
import org.deodev.LibrarySystem.util.BaseQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LibrarianTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    BaseQueue mockQueue;

    @InjectMocks
    Librarian testLibrarian;
    Library testLibrary;
    Book testBook;
    Member testMember;


    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
        testLibrary = new Library();
        testBook = new Book("Dream Count", 1);
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
        testMember = new Member("Teacher", Role.TEACHER);
        testLibrarian.addRequestToQueue(mockQueue, testMember);
        boolean result = testMember.getRequestTime() != null;
        assertTrue(result);
        verify(mockQueue).addToQueue(testMember);
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
        testLibrary.addBook(testBook);

        String bookTitle = testBook.getBookTitle();
        String member1Name = member1.getName();
        String member2Name = member2.getName();

        when(mockQueue.size()).thenReturn(2,1, 0);
        when(mockQueue.getHighestInQueue()).thenReturn(member1, member2);

        testLibrarian.processQueue(mockQueue, testLibrary, testBook.getBookTitle());
        String expected = String.format("%s is issued to %s%nSorry %s there are no more copies of %s%n", bookTitle, member1Name, member2Name, bookTitle);
        assertEquals(expected.trim(), outputStream.toString().trim());
    }


}