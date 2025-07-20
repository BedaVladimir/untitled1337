package ru.stga.tests.create;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.enums.Category;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookResponse;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;
import ru.stga.tests.BookStoreTestBase;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @DataProvider
    public Object[][] bookNegativeCreate() {
        return new Object[][] {
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2)) },
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101)) },
                { Book.defaultOf().setPrice(-1) },
                { Book.defaultOf().setCount(-1) },
                { Book.defaultOf().setCategory(Category.UnknowCategory) }
        };
    }

    @Test(dataProvider = "bookNegativeCreate")
    public void createBooksNegative(Book book) {

        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(400).
                checkErrorResponse(BookResponse.createError400());


    }
}
