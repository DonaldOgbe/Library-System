package org.deodev.LibrarySystem.repository;

import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.validation.InputValidator;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> catalog = new HashMap<>();

    public Book getBook(String title) {
        InputValidator.validateNotNullOrBlank(title);
        validateIfBookExists(title);
        return catalog.get(title);
    }

    public boolean containsBook(String bookId) {
        validateIfBookTitleIsNull(bookId);
        return catalog.containsKey(bookId);
    }

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Invalid book argument");
        if (containsBook(book.getBookTitle())) throw new RuntimeException("Book already exists");
        catalog.put(book.getBookTitle(), book);
    }

    public void removeBook(String bookId) {
        validateIfBookTitleIsNull(bookId);
        validateIfBookExists(bookId);
        catalog.remove(bookId);
    }


//  Validation methods

    public void validateIfBookExists(String book) {
        if (!containsBook(book)) throw new RuntimeException("Book does not exist");
    }

    public void validateIfBookTitleIsNull(String book) {
        if (book == null || book.isEmpty()) throw new IllegalArgumentException("Book argument is null");
    }

}
