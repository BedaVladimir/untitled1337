package ru.stga.tests;


import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.client.TestClient;
import ru.stga.bookstore.tests.rest.enums.Category;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;


public class CreateTestBook {

    @Test
    public void createBookTest() {

        Book book = new Book("The Adventures of Tom Sawyer", "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);

        TestClient testClient = new TestClient();

        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);

        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkCount(response.getCount()).
                checkLastUpdated().
                checkBook(book);
    }

}
