package in.sp.main;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1L, "1984", "George Orwell", 15.99));
        books.add(new Book(2L, "To Kill a Mockingbird", "Harper Lee", 12.99));
    }

    public Book getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
}

