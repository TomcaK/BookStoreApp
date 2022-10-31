package cz.tomaskopulety.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (!Objects.equals(name, author.name)) return false;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
