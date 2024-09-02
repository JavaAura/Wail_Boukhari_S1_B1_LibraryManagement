package com.library.business;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Document {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1); // Thread-safe ID generation

    protected String id;
    protected String title;
    protected String author;
    protected LocalDate publicationDate;
    protected int numberOfPages;
    protected boolean isBorrowed;

    public Document(String title, String author, LocalDate publicationDate, int numberOfPages) {
        this.id = generateId();
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.isBorrowed = false;
    }

    private static String generateId() {
        return String.format("DOC-%04d", NEXT_ID.getAndIncrement());
    }

    public abstract void borrow();
    public abstract void returnDocument();
    public abstract void displayDetails();

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    protected void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
