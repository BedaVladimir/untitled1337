package ru.stga.bookstore.tests.rest.model.response;

import io.restassured.response.Response;

import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.testng.Assert;
import ru.stga.bookstore.tests.rest.model.request.Book;

public class BookValidatableResponse {

    private BookResponse model;
    private Response response;

    @SneakyThrows
    public BookValidatableResponse(Response response) {
        this.response = response;
        model = response.as(BookResponse.class);
    }

    public BookValidatableResponse checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
        return this;
    }

    public BookValidatableResponse checkIdNotNull() {
        response.then().body("id", Matchers.notNullValue());
        return this;
    }

    public BookValidatableResponse checkLastUpdated() {
        response.then().body("lastUpdated", Matchers.notNullValue());
        return this;
    }

    public BookValidatableResponse checkBook(Book expectedBook) {
        Assert.assertEquals(new Book(model), expectedBook);
        return this;
    }

    public BookValidatableResponse checkId(Integer expectedId) {
        response.then().body("id", Matchers.equalTo(expectedId));
        return this;
    }

    public Integer getId() {
        return response.jsonPath().getInt("id");
    }

    public BookValidatableResponse checkCount(Integer expectedCount) {
        response.then().body("count", Matchers.equalTo(expectedCount));
        return this;
    }

    public Integer getCount() {
        return response.jsonPath().getInt("count");
    }

    public BookValidatableResponse checkErrorResponse(BookResponse expectedResponse) {
        response.then().body("timestamp", Matchers.notNullValue());
        Assert.assertEquals(model, expectedResponse);
        return this;
    }
}
