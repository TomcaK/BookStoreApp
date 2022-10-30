package cz.tomaskopulety.bookstore.controller;

import cz.tomaskopulety.bookstore.service.Author;
import cz.tomaskopulety.bookstore.service.Book;
import cz.tomaskopulety.bookstore.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/")
public class StoreController {
    private final Service service;

    @Autowired
    public StoreController(Service service) {
        this.service = service;
    }

    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping(path = "authors")
    public Set<Author> getAuthors() {
        return service.getAuthors();
    }
}
