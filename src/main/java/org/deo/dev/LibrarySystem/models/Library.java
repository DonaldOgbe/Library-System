package org.deo.dev.LibrarySystem.models;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> catalog = new HashMap<>();

    public Book getBook(String title) {
        return catalog.get(title);
    }

    public boolean containsBook(String bookId) {
        return catalog.containsKey(bookId);
    }

    public void addBook(Book book) {
        catalog.put(book.getBookTitle(), book);
    }

    public void removeBook(String bookId) {
        catalog.remove(bookId);
    }


}
