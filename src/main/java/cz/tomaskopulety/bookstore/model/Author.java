package cz.tomaskopulety.bookstore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
