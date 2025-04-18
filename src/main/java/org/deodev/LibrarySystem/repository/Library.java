package org.deodev.LibrarySystem.repository;

import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.validation.CollectionValidator;
import org.deodev.LibrarySystem.validation.InputValidator;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> catalog = new HashMap<>();

    public Book getBook(String title) {
        InputValidator.validateNotNullOrBlank(title);
        CollectionValidator.validateBookExists(catalog, title);
        return catalog.get(title);
    }

    public boolean containsBook(String bookId) {
        InputValidator.validateNotNullOrBlank(bookId);
        return catalog.containsKey(bookId);
    }

    public void addBook(Book book) {
        InputValidator.validateNotNull(book);
        CollectionValidator.validateBookDoesNotExits(catalog, book.getBookTitle());
        catalog.put(book.getBookTitle(), book);
    }

    public void removeBook(String bookId) {
        InputValidator.validateNotNullOrBlank(bookId);
        CollectionValidator.validateBookExists(catalog, bookId);
        catalog.remove(bookId);
    }

}
