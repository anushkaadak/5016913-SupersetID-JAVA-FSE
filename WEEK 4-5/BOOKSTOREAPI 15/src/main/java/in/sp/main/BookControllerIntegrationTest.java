package in.sp.main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        bookRepository.deleteAll();
    }

    @Test
    public void shouldReturnAllBooks() throws Exception {

        Book book1 = new Book(1, "Book1", "Author1");
        Book book2 = new Book(2, "Book2", "Author2");
        bookRepository.save(book1);
        bookRepository.save(book2);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Book1")))
                .andExpect(jsonPath("$[1].title", is("Book2")));
    }

    @Test
    public void shouldReturnBookById() throws Exception {

        Book book = new Book(1, "Book1", "Author1");
        bookRepository.save(book);


        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Book1")));
    }

    @Test
    public void shouldAddBook() throws Exception {
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"New Book\", \"author\":\"New Author\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("New Book")));
        Optional<Book> book = bookRepository.findById(1);
        assert book.isPresent();
        assert book.get().getTitle().equals("New Book");
    }
}
