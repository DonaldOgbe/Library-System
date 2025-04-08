package org.deo.dev;

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


}
