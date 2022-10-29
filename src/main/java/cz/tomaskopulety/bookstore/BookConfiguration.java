package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.BookModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            List<BookModel> bookModels = List.of(
                    new BookModel("On the Basilisk station", 399, "David Weber"),
                    new BookModel("Ashes of the victory", 599, "David Weber"),
                    new BookModel("Dune", 1099, "Frank Herbert"),
                    new BookModel("Children of Dune", 899, "Frank Herbert")
            );
            bookRepository.saveAll(bookModels);
        };

    }
}
