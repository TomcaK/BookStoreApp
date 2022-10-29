package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<BookModel, Integer> {
}
