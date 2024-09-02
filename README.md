# Library Management System

The `Library` class is a fundamental Java implementation designed to manage a collection of documents, such as books and magazines, within a library. This system allows you to add, borrow, return, and display documents, making it easy to keep track of items in the library.

## Features

- **Add Documents:** Add new documents (e.g., books, magazines) to the library's collection.
- **Borrow Documents:** Borrow a document using its unique ID.
- **Return Documents:** Return a previously borrowed document using its ID.
- **Display All Documents:** Display all the documents currently available in the library.
- **Search Documents:** Search for a document by its title.

## Class Structure

### Fields

- **`private List<Document> documents`**  
  A list that stores all documents in the library. This list allows for easy iteration over the documents when performing operations such as displaying all documents.

- **`private Map<String, Document> documentMap`**  
  A map that allows quick lookup of documents by their title. The key is the document title (converted to lowercase), and the value is the corresponding `Document` object.

- **`private int nextId`**  
  An integer counter used to assign a unique ID to each new document added to the library.

### Constructor

- **`public Library()`**  
  Initializes a new instance of the `Library` class. The constructor sets up the `documents` list, the `documentMap` map, and initializes the `nextId` counter to 1.

### Methods

- **`public void addDocument(Document document)`**  
  Adds a new document to the library. The document is stored in the `documents` list and `documentMap` map, making it accessible by both ID and title.

- **`public boolean borrowDocument(int id)`**  
  Attempts to borrow a document from the library by its unique ID. Returns `true` if the document is successfully borrowed, or `false` if the document is already borrowed or does not exist.

- **`public boolean returnDocument(int id)`**  
  Attempts to return a previously borrowed document by its ID. Returns `true` if the document is successfully returned, or `false` if the document was not borrowed or does not exist.

- **`public void displayAllDocuments()`**  
  Displays details of all documents in the library. If the library contains no documents, it prints a message indicating that the library is empty.

- **`public Document searchDocument(String title)`**  
  Searches for a document by its title. If a document with the given title exists, it returns the `Document` object; otherwise, it returns `null`.

- **`private Document findDocumentById(int id)`**  
  A helper method that searches the `documents` list for a document by its ID. Returns the `Document` if found, or `null` if no document with the given ID exists.

- **`public int getNextId()`**  
  Returns the next unique ID for a new document and increments the `nextId` counter for future use.

## Example Usage

Here's how you might use the `Library` class in a Java application:

```java
import library.model.Book;
import library.model.Magazine;
import library.model.Library;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding documents to the library
        library.addDocument(new Book(library.getNextId(), "1984", "George Orwell", "1949-06-08", 328, "0451524934"));
        library.addDocument(new Magazine(library.getNextId(), "National Geographic", "Various Authors", "2023-08-01", 98, 1507));

        // Displaying all documents
        library.displayAllDocuments();

        // Borrowing a document
        boolean success = library.borrowDocument(1);  // Assume 1 is the ID of "1984"
        if (success) {
            System.out.println("Document borrowed successfully.");
        } else {
            System.out.println("Unable to borrow the document.");
        }

        // Returning a document
        success = library.returnDocument(1);  // Assume 1 is the ID of "1984"
        if (success) {
            System.out.println("Document returned successfully.");
        } else {
            System.out.println("Unable to return the document.");
        }

        // Searching for a document by title
        Document doc = library.searchDocument("1984");
        if (doc != null) {
            doc.displayDetails();
        } else {
            System.out.println("Document not found.");
        }
    }
}
```

Requirements :

Java 8 or higher

Installation :

Clone the repository or download the source files.
Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
Compile and run the project.
