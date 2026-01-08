import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

// Main class
public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add a book
    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("✔ Book added successfully!");
    }

    // View all books
    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println(
                "ID: " + b.id +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Status: " + (b.isIssued ? "Issued" : "Available")
            );
        }
    }

    // Search book by ID
    public static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Book Found:");
                System.out.println("Title: " + b.title);
                System.out.println("Author: " + b.author);
                System.out.println("Status: " + (b.isIssued ? "Issued" : "Available"));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Issue book
    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("✔ Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return book
    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("✔ Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: searchBook(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
