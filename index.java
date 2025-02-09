import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            System.out.println("'" + title + "' borrowed successfully.");
        } else {
            System.out.println("'" + title + "' is currently unavailable.");
        }
    }

    public void returnBook() {
        availableCopies++;
        System.out.println("'" + title + "' returned successfully.");
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println();
    }

    public String getTitle() {
        return title;
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    public List<Book> searchByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}

public class index {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some books
        library.addBook(new Book("Java Programming", "James Gosling", "12345", 3));
        library.addBook(new Book("Python Basics", "Guido van Rossum", "67890", 2));
        library.addBook(new Book("Data Structures", "Robert Lafore", "11223", 1));

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    List<Book> borrowBooks = library.searchByTitle(borrowTitle);
                    if (!borrowBooks.isEmpty()) {
                        borrowBooks.get(0).borrowBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    List<Book> returnBooks = library.searchByTitle(returnTitle);
                    if (!returnBooks.isEmpty()) {
                        returnBooks.get(0).returnBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> searchResults = library.searchByTitle(searchTitle);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Books found:");
                        for (Book book : searchResults) {
                            book.displayBookDetails();
                        }
                    } else {
                        System.out.println("No books found with the title.");
                    }
                    break;
                case 4:
                    System.out.println("Displaying all books:");
                    for (Book book : library.searchByTitle("")) {
                        book.displayBookDetails();
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Library System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
