package org.deodev.LibrarySystem.controller;

import org.deodev.LibrarySystem.model.Book;
import org.deodev.LibrarySystem.model.Library;
import org.deodev.LibrarySystem.model.Member;
import org.deodev.LibrarySystem.util.HierarchyQueue;

public class Librarian {

    public void addBook(Book book, Library library) {
        library.addBook(book);
    }

    public void addRequestToQueue(HierarchyQueue queue, Member member) {
        member.setLastBookRequestTime();
        queue.addToQueue(member);
    }

}
