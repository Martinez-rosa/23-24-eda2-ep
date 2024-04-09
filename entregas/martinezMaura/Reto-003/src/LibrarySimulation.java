package entregas.martinezMaura.Reto-003. src;

import java.util.Scanner;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

class LibrarySimulation {
    private List<Book> books;
    private Scanner scanner;

    public LibrarySimulation() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startSimulation() {
        String option;
        boolean isworking = true;
        do {
            System.out.println("===============================");
            System.out.println("Choose an option: ");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books");
            System.out.println("3. Remove a book");
            System.out.println("4. Edit a book");
            System.out.println("5. Exit");
            System.out.println("===============================");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    addBook();
                    break;
                case "2":
                    printBooks();
                    break;
                case "3":
                    printBooks();
                    removeBook();
                    break;
                case "4":
                    printBooks();
                    editBook();
                    break;
                case "5":
                    System.out.println("GOOD BYE");
                    isworking = !isworking;
                default:
                    System.out.println("The option is not valid");
                    break;
            }
        } while (!isworking);
    }

    private void addBook() {
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();
        System.out.println("Enter the category of the book:");
        String category = scanner.nextLine();
        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Enter the publication year of the book:");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(books.size() + 1, title, category, author, year);
        addBook(newBook);
    }

    private void addBook(Book book) {
        books.add(book);
        System.out.println("Book saved");

    }

    public void printBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void removeBook() {
        System.out.print("Enter the title of the book you want to remove: ");
        String title = scanner.nextLine();
        books.removeIf(book -> ((Object) book).getTitle().equals(title));
    }

    public void editBook() {
        System.out.println("===============================");
        System.out.print("Enter the title of the book you want to update: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                String option;
                System.out.println("===============================");
                System.out.println("What do you want to change: ");
                System.out.println("1. Title");
                System.out.println("2. Category");
                System.out.println("3. Author");
                System.out.println("4. Publication Year");
                System.out.println("5. Go Back ");
                System.out.println("===============================");
                option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.print("Enter the new title: ");
                        String newTitle = scanner.nextLine();
                        ((Object) book).setTitle(newTitle);
                        break;
                    case "2":
                        System.out.print("Enter the new category: ");
                        String newCategory = scanner.nextLine();
                        book.setCategory(newCategory);
                        break;
                    case "3":
                        System.out.print("Enter the new author: ");
                        String newAuthor = scanner.nextLine();
                        book.setAuthor(newAuthor);
                        break;
                    case "4":
                        System.out.print("Enter the new publication year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine();
                        book.setYear(newYear);
                        break;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        new LibrarySimulation().startSimulation();
    }
}
