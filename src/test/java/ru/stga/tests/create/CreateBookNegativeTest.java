package ru.stga.tests.create;

import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookResponse;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;
import ru.stga.tests.BookData;
import ru.stga.tests.BookStoreTestBase;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void createBooksNegative(Book book) {

        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());


    }
}
