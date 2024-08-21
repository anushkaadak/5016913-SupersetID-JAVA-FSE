package in.sp.main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Constructor to add some sample books
    public BookController() {
        books.add(new Book(1, "Spring Boot in Action", "Craig Walls", 29.99, "9781617292545"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch", 35.99, "9780134685991"));
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    // Get books by title and author (Query Parameters)
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());
    }

    // Add a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // Update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
        
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setIsbn(updatedBook.getIsbn());
        return book;
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
        
        books.remove(book);
        return ResponseEntity.noContent().build();
    }
}
