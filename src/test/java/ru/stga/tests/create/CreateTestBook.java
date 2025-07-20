package ru.stga.tests.create;

import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;
import ru.stga.tests.BookData;
import ru.stga.tests.BookStoreTestBase;


public class CreateTestBook extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void createBookTest(Book book) {

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
