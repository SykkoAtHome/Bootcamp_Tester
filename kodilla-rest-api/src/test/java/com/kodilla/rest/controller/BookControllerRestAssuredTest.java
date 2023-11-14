package com.kodilla.rest.controller;

import com.google.gson.Gson;
import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
class BookControllerRestAssuredTest {
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        bookService.getBooks().clear();
        RestAssuredMockMvc.standaloneSetup(bookController);  // [2]
    }


    @Test
    void shouldFetchBooks() {
        // given
        Mockito.when(bookService.getBooks())
                .thenReturn(List.of(
                        new BookDto("Title 1", "Author 2"),
                        new BookDto("Title 2", "Author 2"))
                );
        // when then
        when()
                .get("/books")
                .then()
                .body("$.size()", equalTo(2))
                .body("[0].title", equalTo("Title 1"))
                .body("[0].author", equalTo("Author 2"))
                .body("[1].title", equalTo("Title 2"))
                .body("[1].author", equalTo("Author 2"))
                .status(HttpStatus.OK);
    }

    @Test
    void testAddBook() {
        BookDto bookDto = new BookDto("Lord of the rings", "J.R.R. Tolkien");

        given()
                .contentType(ContentType.JSON)
                .body(bookDto)
                .when()
                .post("/books")
                .then()
                .assertThat()
                .statusCode(200);

    }
}