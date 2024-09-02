package com.library.business;

import java.time.LocalDate;

public class Book extends Document {
    private String isbn;

    public Book(String title, String author, LocalDate publicationDate, int numberOfPages, String isbn) {
        super(title, author, publicationDate, numberOfPages);
        this.isbn = isbn;
    }

    @Override
    public void borrow() {
        if (isBorrowed()) {
            System.out.println("The book " + getTitle() + " is already borrowed.");
        } else {
            setBorrowed(true);
            System.out.println("The book " + getTitle() + " has been borrowed.");
        }
    }

    @Override
    public void returnDocument() {
        if (!isBorrowed()) {
            System.out.println("The book " + getTitle() + " was not borrowed.");
        } else {
            setBorrowed(false);
            System.out.println("The book " + getTitle() + " has been returned.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + (isBorrowed() ? "Borrowed" : "Available"));
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
	