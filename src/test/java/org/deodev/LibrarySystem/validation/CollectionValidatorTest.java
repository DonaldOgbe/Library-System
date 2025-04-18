package org.deodev.LibrarySystem.validation;

import org.deodev.LibrarySystem.exception.CollectionException;
import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.repository.Library;
import org.deodev.LibrarySystem.util.BaseQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CollectionValidatorTest {
    @Mock
    Map<String, Book> mockCatalog;
    Book testBook;
    @Mock
    PriorityQueue testQueue;

    @BeforeEach
    void setup() {
        testBook = new Book("Book", 3);
    }



    @Test
    void validateBookExists() {
        when(mockCatalog.containsKey("Wrong Book")).thenReturn(false);
        assertThrows(CollectionException.class, () -> {
            CollectionValidator.validateBookExists(mockCatalog, "Wrong Book");
        });
    }

    @Test
    void validateKeyDoesNotExits() {
        when(mockCatalog.containsKey("Book")).thenReturn(true);
        assertThrows(CollectionException.class, () -> {
            CollectionValidator.validateBookDoesNotExits(mockCatalog, "Book");
        });
    }

    @Test
    void validateQueueNotEmpty() {
        when(testQueue.isEmpty()).thenReturn(true);
        assertThrows(CollectionException.class, () -> {
            CollectionValidator.validateQueueNotEmpty(testQueue);
        });
    }


}