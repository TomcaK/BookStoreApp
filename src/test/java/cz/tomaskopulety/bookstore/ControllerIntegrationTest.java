package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.service.Author;
import cz.tomaskopulety.bookstore.service.Book;
import cz.tomaskopulety.bookstore.model.BookModel;
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
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Service service;
    private List<BookModel> bookModels = List.of(
            new BookModel("On the Basilisk station", 399, "David Weber"),
            new BookModel("Ashes of the victory", 599, "David Weber"),
            new BookModel("Dune", 1099, "Frank Herbert"),
            new BookModel("Children of Dune", 899, "Frank Herbert")
    );

    @Test
    void getBooksTest() throws Exception {
        when(service.getBooks())
                .thenReturn(bookModels.stream()
                        .map(bookModel -> new Book(bookModel.getName(), bookModel.getPrice()))
                        .collect(Collectors.toList()));
        MvcResult result = mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

    @Test
    void getAuthorsTest() throws Exception {
        when(service.getAuthors())
                .thenReturn(Set.of(
                        new Author("David Weber", bookModels),
                        new Author("Frank Herbert", bookModels)
                ));
        MvcResult result = mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

    @Test
    void getWelcomeMessageTest() throws Exception {
        when(service.getWelcomeMessage()).thenReturn("Welcome to Book Store App.\nFor selecting all books write /books. \nFor selecting all authors write /authors.");
        mockMvc.perform(get("http://localhost:8080"))
                .andDo(print())
                .andExpect(content().string(equalTo("Welcome to Book Store App.\nFor selecting all books write /books. \nFor selecting all authors write /authors.")))
                .andExpect(status().isOk());

    }

}
