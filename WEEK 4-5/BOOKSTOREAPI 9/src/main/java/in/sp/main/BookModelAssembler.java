package in.sp.main;





import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, Book> {

    public BookModelAssembler() {
        super(BookController.class, Book.class);
    }

    @Override
    public Book toModel(Book book) {
        book.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
        book.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
        return book;
    }

	public Object toModel(BookDTO book) {
		// TODO Auto-generated method stub
		return null;
	}
}
