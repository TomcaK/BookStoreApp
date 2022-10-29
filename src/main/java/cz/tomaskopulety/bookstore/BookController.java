package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "authors")
    public List<Book> getAuthors() {
        return bookService.getBooks();
    }




}