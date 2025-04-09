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

    public void processQueue(HierarchyQueue queue, Library library, String bookTitle) {

        int numberOfCopies = library.getBook(bookTitle).getNumberOfCopies();
        int lengthOfQueue = queue.size();

        while (lengthOfQueue > 0) {
            Member member = queue.getHighestInQueue();
            if (numberOfCopies > 0) {

//                If the queue is not empty issue a copy based on issuing logic
                member.borrowBook(bookTitle);
                System.out.printf("%s is issued to %s%n", bookTitle, member.getName());

//                update number of copies and length of queue
                library.getBook(bookTitle).setNumberOfCopies(numberOfCopies--);
                lengthOfQueue = queue.size();
            } else {
                System.out.printf("Sorry %s there are no more copies of %s%n", member.getName(), bookTitle);
                lengthOfQueue = queue.size();
            }
        }

    }

}
