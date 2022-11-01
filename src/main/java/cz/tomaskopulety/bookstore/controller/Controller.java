package cz.tomaskopulety.bookstore.controller;

import cz.tomaskopulety.bookstore.dto.AuthorDto;
import cz.tomaskopulety.bookstore.dto.BookDto;
import cz.tomaskopulety.bookstore.dto.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class Controller {
    private final Mapper mapper;

    @Autowired
    public Controller(Mapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(path = "books")
    public List<BookDto> getBooks() {
        return mapper.getBooksDto();
    }

    @GetMapping(path = "authors")
    public List<AuthorDto> getAuthors() {
        return mapper.getAuthorsDto();
    }
}
