package cz.tomaskopulety.bookstore.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Author {
    private String name;
    private List<Book> books;

    public Author(String name, List<BookModel> books) {
        this.name = name;
        this.books = books.stream().map(bookModel -> new Book(bookModel.getName(), bookModel.getPrice())).collect(Collectors.toList());
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
