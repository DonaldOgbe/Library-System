package org.deodev.LibrarySystem.model;

import jdk.jfr.Description;
import org.deodev.LibrarySystem.repository.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    String title;
    int copies;
    Book testBook;

    @BeforeEach
    void setup() {
        title = "Book";
        copies = 3;
        testBook = new Book(title, copies);
    }

    @Test
    void getTitle() {
        String result = testBook.getBookTitle();
        assertEquals("Book", result);
    }

    @Test
    void changeNumberOfCopiesValue() {
        testBook.setNumberOfCopies(2);
        int result = testBook.getNumberOfCopies();
        assertEquals(2, result);
    }


    static Stream<Arguments> getObjectForTesting() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of(new Library(), false),
                Arguments.of(new Book("Book", 3), true)
        );
    }

    @ParameterizedTest
    @MethodSource("getObjectForTesting")
    void testEqualsOverride(Object obj, boolean expected) {
        boolean result = testBook.equals(obj);
        assertEquals(expected, result);
    }



}