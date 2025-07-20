package ru.stga.tests.update;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookResponse;
import ru.stga.tests.BookData;
import ru.stga.tests.BookStoreTestBase;

public class UpdateBookNegativeTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient.create(Book.defaultOf()).checkStatusCode(201).getId();
    }

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.updateError400(id));

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(Book.defaultOf());
    }
}

