package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.model.Author;
import cz.tomaskopulety.bookstore.model.Book;
import cz.tomaskopulety.bookstore.service.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Service service;
    private List<Author> authors = List.of(
            new Author("David Weber"),
            new Author("Frank Herbert")
    );

    private List<Book> books = List.of(
            new Book("On the Basilisk station", 399, authors.get(0)),
            new Book("Ashes of the victory", 599, authors.get(0)),
            new Book("Dune", 1099, authors.get(1)),
            new Book("Children of Dune", 899, authors.get(1))
    );

    @Test
    void getBooksTest() throws Exception {
        when(service.getBooks())
                .thenReturn(books);
        MvcResult result = mockMvc.perform(get("/api/v1/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

    @Test
    void getAuthorsTest() throws Exception {
        when(service.getAuthors())
                .thenReturn(authors);
        MvcResult result = mockMvc.perform(get("/api/v1/authors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

}
