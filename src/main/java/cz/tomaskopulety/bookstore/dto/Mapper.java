package cz.tomaskopulety.bookstore.dto;

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
