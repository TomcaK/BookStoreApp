package cz.tomaskopulety.bookstore.controller;

import cz.tomaskopulety.bookstore.dto.AuthorDto;
import cz.tomaskopulety.bookstore.dto.BookDto;
import cz.tomaskopulety.bookstore.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping(path = "books")
    public List<BookDto> getBooks() {
        return service.getBooks();
    }

    @GetMapping(path = "authors")
    public List<AuthorDto> getAuthors() {
        return service.getAuthors();
    }
}
