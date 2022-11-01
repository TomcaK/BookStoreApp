package cz.tomaskopulety.bookstore.service;

import cz.tomaskopulety.bookstore.dto.AuthorDto;
import cz.tomaskopulety.bookstore.dto.BookDto;
import cz.tomaskopulety.bookstore.repository.AuthorRepository;
import cz.tomaskopulety.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final Mapper mapper;

    @Autowired
    public Service(BookRepository bookRepository, AuthorRepository authorRepository, Mapper mapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(mapper::toBookDto).collect(Collectors.toList());
    }

    public List<AuthorDto> getAuthors() {
        return authorRepository.findAll().stream().map(mapper::toAuthorDto).collect(Collectors.toList());
    }
}
