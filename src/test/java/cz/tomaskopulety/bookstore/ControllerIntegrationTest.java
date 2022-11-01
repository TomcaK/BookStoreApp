package cz.tomaskopulety.bookstore;

import cz.tomaskopulety.bookstore.dto.AuthorDto;
import cz.tomaskopulety.bookstore.dto.BookDto;
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
    private List<AuthorDto> authors = List.of(
            new AuthorDto("David Weber",
                    List.of(new BookDto("On the Basilisk station", 399),
                            new BookDto("Ashes of the victory", 599))),
            new AuthorDto("Frank Herbert",
                    List.of(new BookDto("Dune", 1099),
                            new BookDto("Children of Dune", 899)))
    );

    private List<BookDto> books = List.of(
            new BookDto("On the Basilisk station", 399),
            new BookDto("Ashes of the victory", 599),
            new BookDto("Dune", 1099),
            new BookDto("Children of Dune", 899)
    );

    @Test
    void getBooksTest() throws Exception {
        when(service.getBooks())
                .thenReturn(books);
        MvcResult result = mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

    @Test
    void getAuthorsTest() throws Exception {
        when(service.getAuthors())
                .thenReturn(authors);
        MvcResult result = mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertNotEquals("[]", result.getResponse().getContentAsString());
    }

}
