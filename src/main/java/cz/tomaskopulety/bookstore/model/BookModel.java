package cz.tomaskopulety.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int price;
    private String author;


    public BookModel(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public BookModel() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
