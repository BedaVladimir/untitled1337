package ru.stga.bookstore.tests.rest.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import ru.stga.bookstore.tests.props.TestConfig;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class TestClient {

    private String baseUri;
    private String basePath;

    public TestClient() {
        this(TestConfig.Uri.value, TestConfig.Path.value);
    }

    private RequestSpecification getRequestSpec() {
        /*
        в этом методе выполняем базовые действия перед выполнением
         */

        return given().
                baseUri(baseUri).
                basePath(basePath).
                contentType(ContentType.JSON).
                log().all();
    }

    private RequestSpecification getRequestSpec(Object body) {
        /*
        те же базовые действия + body
         */

        return getRequestSpec().
                body(body);
    }

    public BookValidatableResponse create(Book book) {
        /*
        пост метод с созданием книги
         */
        Response response = getRequestSpec(book).when().
                post("/books");

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse read(Integer id) {
        /*
        гет метод получения книги по айди
         */
        Response response = getRequestSpec().when().
                get("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse update(Integer id, Book book) {
        /*
        пут метод для обновления книги по айди
         */
        Response response = getRequestSpec(book).when().
                put("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }
}
