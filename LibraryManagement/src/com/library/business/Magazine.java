package com.library.business;

import java.time.LocalDate;

public class Magazine extends Document {
    private int issue;

    public Magazine(String title, String author, LocalDate publicationDate, int numberOfPages, int issue) {
        super(title, author, publicationDate, numberOfPages);
        this.issue = issue;
    }

    @Override
    public void borrow() {
        if (isBorrowed()) {
            System.out.println("The magazine " + getTitle() + " is already borrowed.");
        } else {
            setBorrowed(true);
            System.out.println("The magazine " + getTitle() + " has been borrowed.");
        }
    }

    @Override
    public void returnDocument() {
        if (!isBorrowed()) {
            System.out.println("The magazine " + getTitle() + " was not borrowed.");
        } else {
            setBorrowed(false);
            System.out.println("The magazine " + getTitle() + " has been returned.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Number of Pages: " + getNumberOfPages());
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + (isBorrowed() ? "Borrowed" : "Available"));
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }
}
