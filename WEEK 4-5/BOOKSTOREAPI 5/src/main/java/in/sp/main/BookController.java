package in.sp.main;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        return ResponseEntity.ok()
                             .header("Custom-Header", "CustomHeaderValue")
                             .body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(b -> b.getId().equals(id));

        if (removed) {
            return ResponseEntity.noContent()
                                 .header("X-Deleted-Book-ID", id.toString())
                                 .build();
        } else {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }
    }
}
