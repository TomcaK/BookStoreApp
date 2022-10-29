package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
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
        database.forEach(book -> {
            set.add(
                    new Author(book.getAuthor(),
                            database.stream()
                                    .filter(bookModel -> bookModel.getAuthor().equals(book.getAuthor()))
                                    .collect(Collectors.toList())));
        });
        return set;
    }
}
