package cz.tomaskopulety.bookstore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String name, int price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(name, book.name)) return false;
        return Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
