package com.library.business;

import java.util.*;

public class Library {
    private final List<Document> documents;
    private final Map<String, Document> documentMap;

    public Library() {
        this.documents = new ArrayList<>();
        this.documentMap = new HashMap<>();
    }

    public synchronized void addDocument(Document document) {
        documents.add(document);
        documentMap.put(document.getId(), document);
    }

    public synchronized Document searchDocument(String id) {
        return documentMap.get(id);
    }

    public synchronized void borrowDocument(String id) {
        Document document = searchDocument(id);
        if (document != null) {
            document.borrow();
        } else {
            System.out.println("Document not found.");
        }
    }

    public synchronized void returnDocument(String id) {
        Document document = searchDocument(id);
        if (document != null) {
            document.returnDocument();
        } else {
            System.out.println("Document not found.");
        }
    }

    public void displayAllDocuments() {
        for (Document document : documents) {
            document.displayDetails();
            System.out.println("--------------------");
        }
    }
}
