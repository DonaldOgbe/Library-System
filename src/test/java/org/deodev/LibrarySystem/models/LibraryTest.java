package org.deodev.LibrarySystem.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertTrue(result.equals(testBook));
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
    void removeBookFromCatalog() {
        testLibrary.removeBook(testBook.getBookTitle());
        boolean result = testLibrary.containsBook(testBook.getBookTitle());
        assertFalse(result);
    }


}