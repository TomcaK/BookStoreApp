package cz.tomaskopulety.bookstore.model;

import java.util.List;


public class Author {


    private String name;
    private List<Book> books;

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
