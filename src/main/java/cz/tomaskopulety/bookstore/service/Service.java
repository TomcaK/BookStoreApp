package cz.tomaskopulety.bookstore.service;

import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
import cz.tomaskopulety.bookstore.repository.AuthorRepository;
import cz.tomaskopulety.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public Service(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }


//    public List<Book> getBooks() {
////        return getDatabase().stream()
////                .map(bookModel -> new Book(bookModel.getName(), bookModel.getPrice()))
////                .collect(Collectors.toList());
//    }
//
//    public Set<Author> getAuthors() {
////        List<BookModel> database = getDatabase();
////        Set<Author> set = new HashSet<>();
////        database.forEach(book ->
////            set.add(new Author(book.getAuthor(),database)));
////        return set;
//    }

    public String getWelcomeMessage() {
        return "Welcome to Book Store App.\n" +
                "For selecting all books write /books. \n" +
                "For selecting all authors write /authors.";
    }

}
