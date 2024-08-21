package in.sp.main;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
            .map(book -> modelMapper.map(book, BookDTO.class))
            .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTO addBook(@Valid BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTO updateBook(Long id, @Valid BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        modelMapper.map(bookDTO, book);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDTO.class);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
