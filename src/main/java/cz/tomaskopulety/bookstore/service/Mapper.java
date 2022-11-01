package cz.tomaskopulety.bookstore.service;

import cz.tomaskopulety.bookstore.dto.AuthorDto;
import cz.tomaskopulety.bookstore.dto.BookDto;
import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {

    public AuthorDto toAuthorDto(Author author) {
        return new AuthorDto(author.getName(), author.getBooks().stream().map(this::toBookDto).collect(Collectors.toList()));
    }

    public BookDto toBookDto(Book book) {
        return new BookDto(book.getName(), book.getPrice());
    }
}
