package cz.tomaskopulety.bookstore.service;

import cz.tomaskopulety.bookstore.repository.Repository;
import cz.tomaskopulety.bookstore.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    private List<BookModel> getDatabase() {
        return repository.findAll();

    }

    public List<Book> getBooks() {
        return getDatabase().stream()
                .map(bookModel -> new Book(bookModel.getName(), bookModel.getPrice()))
                .collect(Collectors.toList());
    }

    public Set<Author> getAuthors() {
        List<BookModel> database = getDatabase();
        Set<Author> set = new HashSet<>();
        database.forEach(book ->
            set.add(new Author(book.getAuthor(),database)));
        return set;
    }

    public String getWelcomeMessage() {
        return "Welcome to Book Store App.\n" +
                "For selecting all books write /books. \n" +
                "For selecting all authors write /authors.";
    }

}
