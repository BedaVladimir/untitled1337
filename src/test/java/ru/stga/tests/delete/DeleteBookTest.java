package ru.stga.tests.delete;

import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;
import ru.stga.tests.BookStoreTestBase;

public class DeleteBookTest extends BookStoreTestBase {

    @Test
    public void testDeleteBook() {
        BookValidatableResponse response = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.delete(response.getId()).
                checkStatusCode(200);

        testClient.read(response.getId()).
                checkStatusCode(404);
    }

    @Test
    public void testDeleteNotExistedBook() {
        testClient.delete(9999999).
                checkStatusCode(404);
    }
}
