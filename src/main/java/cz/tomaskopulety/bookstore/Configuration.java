package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
import cz.tomaskopulety.bookstore.repository.AuthorRepository;
import cz.tomaskopulety.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
        return args -> {

            if (authorRepository.count() == 0) {
                List<Author> authors = List.of(
                        new Author("David Weber"),
                        new Author("Frank Herbert")
                );
                authorRepository.saveAll(authors);
                List<Book> books = List.of(
                        new Book("On the Basilisk station", 399, authors.get(0)),
                        new Book("Ashes of the victory", 599, authors.get(0)),
                        new Book("Dune", 1099, authors.get(1)),
                        new Book("Children of Dune", 899, authors.get(1))
                );
                bookRepository.saveAll(books);
            }
        };
    }


}
