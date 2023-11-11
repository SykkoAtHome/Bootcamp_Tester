package com.kodilla.rest.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void shouldFetchBooks() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("Title 1", "Author 1"));
        booksList.add(new BookDto("Title 2", "Author 2"));
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);

        //when
        List<BookDto> result = bookController.getBooks();

        //then
        assertThat(result).hasSize(2);
    }
    @Test
    void testAddBook() {
        // given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto bookDto = new BookDto("Title 1", "Author 1");

        // when
        bookController.addBook(bookDto);

        // then
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(bookDto);
    }
    @Test
    void testAddBookWithMockMVC() throws Exception {
        // given
        BookDto bookDto = new BookDto("Title 1", "Author 1");

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/books")  //wysylam (post) na endpointa
                        .contentType(MediaType.APPLICATION_JSON) //ustalam format na json
                        .content(new Gson().toJson(bookDto))) //nowy obiekt Gson z obiektu bookDto - format json
                .andExpect(MockMvcResultMatchers.status().is(200)); //spodziewam sie odpowiedzi 200 z ep

        // then
        Mockito.verify(bookService, Mockito.times(1)).addBook(bookDto); // czy addBook wywolano 1raz
        Mockito.when(bookService.getBooks()).thenReturn(Collections.singletonList(bookDto)); // mock ma zwracac liste gdy wywoluje getBooks
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(result -> {
                    List<BookDto> books = new Gson().fromJson(result.getResponse().getContentAsString(), new TypeToken<List<BookDto>>() {}.getType()); // tworze liste i odwracam proces konwersji json > na obiekt bookDto
                    assertThat(books).hasSize(1); // sprawdzam ze czy jest 1 obiekt na liscie
                    assertThat(books.get(0)).isEqualTo(bookDto); // spradzam czy ksiazka w liscie (index 0) to ta sama ksiazka dodana wczesniej w //given
                });
    }
}