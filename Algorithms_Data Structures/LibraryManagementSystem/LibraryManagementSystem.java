import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLibrary();
        
        while (true) {
            System.out.println("\n1. Add a book");
            System.out.println("2. Search book by title (Linear Search)");
            System.out.println("3. Search book by title (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBookLinear();
                    break;
                case 3:
                    searchBookBinary();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeLibrary() {
        books.add(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "Pride and Prejudice", "Jane Austen"));
        books.add(new Book(4, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(5, "Moby Dick", "Herman Melville"));
    }
    

    private static void addBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        for(Book book :books){
            if (book.getBookId() == id) {
                System.out.println("ID alreay in use.");
                return;
            }
        }
        scanner.nextLine(); // Consume newline
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void searchBookLinear() {
        System.out.print("Enter the title to search: ");
        String searchTitle = scanner.nextLine();
        
        long startTime = System.nanoTime();
        Book result = linearSearch(searchTitle);
        long endTime = System.nanoTime();
        
        if (result != null) {
            System.out.println("Book found: " + result);
        } else {
            System.out.println("Book not found.");
        }
        
        System.out.println("Linear search time: " + (endTime - startTime) + " nanoseconds");
    }

    private static Book linearSearch(String searchTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                return book;
            }
        }
        return null;
    }

    private static void searchBookBinary() {
        // Sort the books by title for binary search
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        
        System.out.print("Enter the title to search: ");
        String searchTitle = scanner.nextLine();
        
        long startTime = System.nanoTime();
        Book result = binarySearch(searchTitle);
        long endTime = System.nanoTime();
        
        if (result != null) {
            System.out.println("Book found: " + result);
        } else {
            System.out.println("Book not found.");
        }
        
        System.out.println("Binary search time: " + (endTime - startTime) + " nanoseconds");
    }

    private static Book binarySearch(String searchTitle) {
        int left = 0;
        int right = books.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(searchTitle);
            
            if (comparison == 0) {
                return books.get(mid);
            }
            
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return null;
    }
}