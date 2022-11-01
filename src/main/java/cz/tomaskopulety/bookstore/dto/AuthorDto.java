package cz.tomaskopulety.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthorDto {
    private String name;
    @JsonProperty("books")
    private List<BookDto> bookDtos;

    public AuthorDto(String name, List<BookDto> bookDtos) {
        this.name = name;
        this.bookDtos = bookDtos;
    }

    public String getName() {
        return name;
    }

    public List<BookDto> getBookDtos() {
        return bookDtos;
    }
}
