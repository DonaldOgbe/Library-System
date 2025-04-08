package org.deo.dev.LibrarySystem.models;

public class Book {
    private String title;
    private int copies;

    public Book(String title, int copies) {
        this.title = title;
        this.copies = copies;
    }

    public String getBookTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return copies;
    }

    public void setNumberOfCopies(int num) {
        copies = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return book.getBookTitle().equals(this.title)  && book.getNumberOfCopies() == this.copies;
    }

}
