package cz.tomaskopulety.bookstore.model;

import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private long id;
    private String name;
    private int price;
    private String author;


    public Book(String name, int price,String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book() {
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
