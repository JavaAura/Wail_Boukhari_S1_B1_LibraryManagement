package com.library.presentation;

import com.library.business.*;
import com.library.utility.DateUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private Library library;
    private Scanner scanner;

    public ConsoleUI() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            int choice = getUserInput("Enter your choice (1-6): ", 1, 6);

            switch (choice) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    borrowDocument();
                    break;
                case 3:
                    returnDocument();
                    break;
                case 4:
                    displayAllDocuments();
                    break;
                case 5:
                    searchDocument();
                    break;
                case 6:
                    isRunning = false;
                    break;
            }
        }
        System.out.println("Goodbye!");
    }

    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add a document");
        System.out.println("2. Borrow a document");
        System.out.println("3. Return a document");
        System.out.println("4. Display all documents");
        System.out.println("5. Search for a document");
        System.out.println("6. Exit");
    }

    private void addDocument() {
        System.out.println("Add a document:");

        int type = getUserInput("Type (1 for Book, 2 for Magazine): ", 1, 2);

        String title = getStringInput("Title: ");
        String author = getStringInput("Author: ");
        LocalDate publicationDate = getDateInput("Publication date (dd/mm/yyyy): ");
        int numberOfPages = getUserInput("Number of pages: ", 1, Integer.MAX_VALUE);

        Document document;
        if (type == 1) {
            String isbn = getStringInput("ISBN: ");
            document = new Book(title, author, publicationDate, numberOfPages, isbn);
        } else {
            int issue = getUserInput("Issue number: ", 1, Integer.MAX_VALUE);
            document = new Magazine(title, author, publicationDate, numberOfPages, issue);
        }

        library.addDocument(document);
        System.out.println("Document added successfully.");
    }

    private void borrowDocument() {
        String id = getStringInput("Enter the ID of the document to borrow: ");
        library.borrowDocument(id);
    }

    private void returnDocument() {
        String id = getStringInput("Enter the ID of the document to return: ");
        library.returnDocument(id);
    }

    private void displayAllDocuments() {
        library.displayAllDocuments();
    }

    private void searchDocument() {
        String id = getStringInput("Enter the ID of the document to search: ");
        Document document = library.searchDocument(id);
        if (document != null) {
            document.displayDetails();
        } else {
            System.out.println("Document not found.");
        }
    }

    private int getUserInput(String prompt, int min, int max) {
        int input = -1;
        while (input < min || input > max) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (input < min || input > max) {
                    System.out.println("Input out of range. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return input;
    }

    private LocalDate getDateInput(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = DateUtils.stringToDate(dateString);
            } catch (DateTimeException e) {
                System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date. Please enter a valid date.");
            }
        }
        return date;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
