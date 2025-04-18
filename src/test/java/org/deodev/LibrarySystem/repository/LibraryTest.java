package org.deodev.LibrarySystem.repository;

import org.deodev.LibrarySystem.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Book testBook;
    Library testLibrary;

    @BeforeEach
    void setup() {
        testBook = new Book("Dream Count", 3);
        testLibrary = new Library();
        testLibrary.addBook(testBook);
    }

    @Test
    void getBook() {
        Book result = testLibrary.getBook("Dream Count");
        assertEquals(result, testBook);
    }

    @ParameterizedTest
    @CsvSource({"Dream Count, true",
                "Purple Hibiscus, false"})
    void checkIfLibraryHasBook(String book, boolean expected) {
        boolean result = testLibrary.containsBook(book);
        assertEquals(expected, result);
    }

    @Test
    void addBook() {
        boolean result = testLibrary.containsBook(testBook.getBookTitle());
        assertTrue(result);
    }

    @Test
    void throwErrorForExistingBook() {
        assertThrows(RuntimeException.class, () -> {
            testLibrary.addBook(new Book("Dream Count", 3));
        });
    }

    @Test
    void removeBookFromCatalog() {
        testLibrary.removeBook(testBook.getBookTitle());
        boolean result = testLibrary.containsBook(testBook.getBookTitle());
        assertFalse(result);
    }

}