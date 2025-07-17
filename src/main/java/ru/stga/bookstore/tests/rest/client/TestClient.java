package ru.stga.bookstore.tests.rest.client;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import ru.stga.bookstore.tests.props.TestConfig;
import ru.stga.bookstore.tests.rest.model.request.Book;

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
        те же базовые действия +  body
         */

        return getRequestSpec().
                body(body);
    }

    public ValidatableResponse create(Book book) {
        /*
        пост метод с созданием книги
         */
        return getRequestSpec(book).
                when().post("books").
                then().log().all();
    }
}
