package cz.tomaskopulety.bookstore.dto;

import java.util.List;

public class AuthorDto {
    private String name;
    private List<BookDto> bookDtos;

    public AuthorDto(String name, List<BookDto> bookDtos) {
        this.name = name;
        this.bookDtos = bookDtos;
    }
}
