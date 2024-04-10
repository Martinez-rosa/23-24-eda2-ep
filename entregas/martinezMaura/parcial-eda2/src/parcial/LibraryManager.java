package parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Document> documents;
    private List<Author> authors;
    private List<DocumentAuthor> DocumentAuthors;
    private Scanner scanner;

    public LibraryManager() {
        documents = new ArrayList<>();
        authors = new ArrayList<>();
        DocumentAuthors = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n----- Library Management System Menu -----");
            System.out.println("1. Add a new document");
            System.out.println("2. Add a new author");
            System.out.println("3. Associate an author with a document");
            System.out.println("4. Search for a document by ID");
            System.out.println("5. Search for an author by ID");
            System.out.println("6. List all documents");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    addAuthor();
                    break;
                case 3:
                    associateAuthorWithDocument();
                    break;
                case 4:
                    searchDocumentById();
                    break;
                case 5:
                    searchAuthorById();
                    break;
                case 6:
                    listAllDocuments();
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);
    }

    private void addDocument() {

        int id = documents.size() + 1;

        System.out.println("Enter the ID of the document:");
        scanner.nextLine();
        System.out.println("Enter the title of the document:");
        String title = scanner.nextLine();
        System.out.println("Enter the publication year:");
        int publicationYear = scanner.nextInt();
        System.out.println("Enter the type of document (1-2-3-4):");
        System.out.println("1. BOOK 2. MAGAZINE 3. ARTICLE 4. PAPER");

        int typeOption = scanner.nextInt();

        DocumentType type = null;
        switch (typeOption) {
            case 1:
                type = DocumentType.BOOK;
                break;
            case 2:
                type = DocumentType.MAGAZINE;
                break;
            case 3:
                type = DocumentType.ARTICLE;
                break;
            case 4:
                type = DocumentType.PAPER;
                break;
            default:
                System.out.println("Invalid document type. Defaulting to BOOK.");
                type = DocumentType.BOOK;
                break;
        }
        Document document = new Document(id, title, publicationYear, type);
        documents.add(document);
        boolean addAuthors = true;
    while (addAuthors) {
        System.out.println("Do you want to add an author to this document? (Y/N)");
        String choice = scanner.next().toUpperCase();
        scanner.nextLine(); // Consume newline

        if (choice.equals("Y")) {
            addAuthorToDocument(document.getId());
        } else {
            addAuthors = false;
        }
        System.out.println("Document added successfully!");
    }

    private void addAuthorToDocument(int documentId) {
      
        int authorId = authors.size() + 1;
    
        System.out.println("Enter the full name of the author:");
        String fullName = scanner.nextLine();
    
        Author author = new Author(authorId, fullName);
        authors.add(author);
    
       
        DocumentAuthor documentAuthor = new DocumentAuthor(documentId, authorId);
        DocumentAuthors.add(documentAuthor);

    private void addAuthor() {
        System.out.println("Enter the ID of the author:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the full name of the author:");
        String fullName = scanner.nextLine();
        Author author = new Author(id, fullName);
        authors.add(author);
        System.out.println("Author added successfully!");
    }

    private void associateAuthorWithDocument() {
        System.out.println("Enter the ID of the document:");
        int documentId = scanner.nextInt();
        System.out.println("Enter the ID of the author:");
        int authorId = scanner.nextInt();
        DocumentAuthor DocumentAuthor = new DocumentAuthor(documentId, authorId);
        DocumentAuthors.add(DocumentAuthor);
        System.out.println("Author associated with document successfully!");
    }

    private void searchDocumentById() {
        System.out.println("Enter the ID of the document:");
        int id = scanner.nextInt();
        for (Document document : documents) {
            if (document.getId() == id) {
                System.out.println(document);
                List<Author> associatedAuthors = getAuthorsByDocumentId(id);
                for (Author author : associatedAuthors) {
                    System.out.println(author);
                }
                return;
            }
        }
        System.out.println("Document not found.");
    }

    private void searchAuthorById() {
        System.out.println("Enter the ID of the author:");
        int id = scanner.nextInt();
        for (Author author : authors) {
            if (author.getId() == id) {
                System.out.println(author);
                List<Document> associatedDocuments = getDocumentsByAuthorId(id);
                for (Document document : associatedDocuments) {
                    System.out.println(document);
                }
                return;
            }
        }
        System.out.println("Author not found.");
    }

    private List<Author> getAuthorsByDocumentId(int documentId) {
        List<Author> associatedAuthors = new ArrayList<>();
        for (DocumentAuthor DocumentAuthor : DocumentAuthors) {
            if (DocumentAuthor.getDocumentId() == documentId) {
                Author author = getAuthorById(DocumentAuthor.getAuthorId());
                if (author != null) {
                    associatedAuthors.add(author);
                }
            }
        }
        return associatedAuthors;
    }

    private List<Document> getDocumentsByAuthorId(int authorId) {
        List<Document> associatedDocuments = new ArrayList<>();
        for (DocumentAuthor DocumentAuthor : DocumentAuthors) {
            if (DocumentAuthor.getAuthorId() == authorId) {
                Document document = getDocumentById(DocumentAuthor.getDocumentId());
                if (document != null) {
                    associatedDocuments.add(document);
                }
            }
        }
        return associatedDocuments;
    }

    private Document getDocumentById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null;
    }

    private Author getAuthorById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    private void listAllDocuments() {
        System.out.println("----- List of Documents -----");
        for (Document document : documents) {
            System.out.println(document);
            List<Author> associatedAuthors = getAuthorsByDocumentId(document.getId());
            for (Author author : associatedAuthors) {
                System.out.println("  - " + author);
            }

        }
    }

}
