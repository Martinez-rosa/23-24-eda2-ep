package entregas.parcialEda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Document> documents;
    private List<Author> authors;
    private List<AuthorDocument> authorDocuments;
    private Scanner scanner;

    public LibraryManager() {
        documents = new ArrayList<>();
        authors = new ArrayList<>();
        authorDocuments = new ArrayList<>();
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

    public void addDocument() {
        System.out.println("Enter the ID of the document:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the title of the document:");
        String title = scanner.nextLine();
        System.out.println("Enter the publication year:");
        int publicationYear = scanner.nextInt();
        System.out.println("Enter the type of document:");
        System.out.println("1. BOOK 2. MAGAZINE 3. ARTICLE 4. PAPER");
        int typeOption = scanner.nextInt();
        Type type = null;
        switch (typeOption) {
            case 1:
                type = Type.BOOK;
                break;
            case 2:
                type = Type.MAGAZINE;
                break;
            case 3:
                type = Type.ARTICLE;
                break;
            case 4:
                type = Type.PAPER;
                break;
            default:
                System.out.println("Invalid document type. Defaulting to BOOK.");
                type = Type.BOOK;
                break;
        }
        Document document = new Document(id, title, publicationYear, type);
        documents.add(document);
        System.out.println("Document added successfully!");
    }

    public void addAuthor() {
        System.out.println("Enter the ID of the author:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the full name of the author:");
        String fullName = scanner.nextLine();
        Author author = new Author(id, fullName);
        authors.add(author);
        System.out.println("Author added successfully!");
    }

    public void associateAuthorWithDocument() {
        System.out.println("Enter the ID of the document:");
        int documentId = scanner.nextInt();
        System.out.println("Enter the ID of the author:");
        int authorId = scanner.nextInt();
        AuthorDocument authorDocument = new AuthorDocument(documentId, authorId);
        authorDocuments.add(authorDocument);
        System.out.println("Author associated with document successfully!");
    }

    public void searchDocumentById() {
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

    public void searchAuthorById() {
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

    public List<Author> getAuthorsByDocumentId(int documentId) {
        List<Author> associatedAuthors = new ArrayList<>();
        for (AuthorDocument authorDocument : authorDocuments) {
            if (authorDocument.getDocumentId() == documentId) {
                Author author = getAuthorById(authorDocument.getAuthorId());
                if (author != null) {
                    associatedAuthors.add(author);
                }
            }
        }
        return associatedAuthors;
    }

    public List<Document> getDocumentsByAuthorId(int authorId) {
        List<Document> associatedDocuments = new ArrayList<>();
        for (AuthorDocument authorDocument : authorDocuments) {
            if (authorDocument.getAuthorId() == authorId) {
                Document document = getDocumentById(authorDocument.getDocumentId());
                if (document != null) {
                    associatedDocuments.add(document);
                }
            }
        }
        return associatedDocuments;
    }

    public Document getDocumentById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null;
    }

    public Author getAuthorById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public void listAllDocuments() {
        System.out.println("----- List of Documents -----");
        for (Document document : documents) {
            System.out.println(document);
            List<Author> associatedAuthors = getAuthorsByDocumentId(document.getId());
            for (Author author : associatedAuthors) {
                System.out.println("  - " + author);
            }

        }
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.displayMenu(); /
    }

}
