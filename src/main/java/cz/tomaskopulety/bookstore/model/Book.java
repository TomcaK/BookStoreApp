package cz.tomaskopulety.bookstore.model;

import javax.persistence.*;

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
}
