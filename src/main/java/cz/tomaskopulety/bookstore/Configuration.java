package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.BookModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    CommandLineRunner commandLineRunner(Repository repository) {
        return args -> {
            List<BookModel> bookModels = List.of(
                    new BookModel("On the Basilisk station", 399, "David Weber"),
                    new BookModel("Ashes of the victory", 599, "David Weber"),
                    new BookModel("Dune", 1099, "Frank Herbert"),
                    new BookModel("Children of Dune", 899, "Frank Herbert")
            );
            repository.saveAll(bookModels);
        };

    }
}
