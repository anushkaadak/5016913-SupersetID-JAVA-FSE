import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        this.books = new Book[capacity];
        this.size = 0;
    }

    public void addBook(int bookId, String title, String author) {
        if (size == books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }
        books[size] = new Book(bookId, title, author);
        size++;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
    }

    public void traverseBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(10);
        Scanner scanner = new Scanner(System.in);

        lms.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald");
        lms.addBook(2, "To Kill a Mockingbird", "Harper Lee");
        lms.addBook(3, "1984", "George Orwell");
        lms.addBook(4, "Pride and Prejudice", "Jane Austen");
        lms.addBook(5, "The Catcher in the Rye", "J.D. Salinger");

        System.out.println("All Books:");
        lms.traverseBooks();

        System.out.print("Enter title to search (Linear Search): ");
        String title = scanner.nextLine();
        Book book = lms.linearSearchByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        lms.sortBooksByTitle();

        System.out.print("Enter title to search (Binary Search): ");
        title = scanner.nextLine();
        book = lms.binarySearchByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();
    }
}
