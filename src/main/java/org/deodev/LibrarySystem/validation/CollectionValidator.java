package org.deodev.LibrarySystem.validation;


import org.deodev.LibrarySystem.exception.CollectionException;
import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.util.BaseQueue;

import java.util.Collection;
import java.util.Map;
import java.util.PriorityQueue;

public class CollectionValidator {
    private CollectionValidator() {}

    public static void validateBookExists(Map<String, Book> catalog, String bookTitle) {
        if (!catalog.containsKey(bookTitle)) throw new CollectionException("Library Catalog does not contain Book");
    }

    public static void validateBookDoesNotExits(Map<String, Book> catalog, String bookTitle) {
        if (catalog.containsKey(bookTitle)) throw new CollectionException("Catalog already contains Book");
    }

    public static void validateQueueNotEmpty(PriorityQueue queue) {
        if (queue.isEmpty()) throw new CollectionException("Queue is empty");
    }

}
