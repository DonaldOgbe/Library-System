package org.deo.dev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    String title;
    int copies;
    Book testBook;

    @BeforeEach
    void setup() {
        title = "Dream Count";
        copies = 3;
        testBook = new Book(title, copies);
    }

    @Test
    void getTitle() {
        String result = testBook.getBookTitle();
        assertEquals("Dream Count", result);
    }

    @Test
    void getNumberOfCopies() {
        int result = testBook.getNumberOfCopies();
        assertEquals(3, result);
    }

    @Test
    void setNumberOfCopies() {
        testBook.setNumberOfCopies(2);
        int result = testBook.getNumberOfCopies();
        assertEquals(2, result);
    }


}