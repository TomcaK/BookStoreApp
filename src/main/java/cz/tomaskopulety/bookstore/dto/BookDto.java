package cz.tomaskopulety.bookstore.dto;

public class BookDto {
    private String name;
    private int price;

    public BookDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
