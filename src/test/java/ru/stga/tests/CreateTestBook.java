package ru.stga.tests;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stga.bookstore.tests.rest.client.TestClient;
import ru.stga.bookstore.tests.rest.enums.Category;
import ru.stga.bookstore.tests.rest.model.request.Book;
import ru.stga.bookstore.tests.rest.model.response.BookValidatableResponse;


public class CreateTestBook {

    @DataProvider
    public Object[][] createBooks() {
        return new Object[][] {
                { Book.defaultOf() },
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3)) },
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100)) },
                { Book.defaultOf().setPrice(0) },
                { Book.defaultOf().setCount(0) },
                { Book.defaultOf().setCategory(Category.Detective) },
                { Book.defaultOf().setCategory(Category.Horror) },
                { Book.defaultOf().setCategory(Category.Thriller) },
                { Book.defaultOf().setCategory(Category.Fiction)}
        };
    }

    @Test(dataProvider = "createBooks")
    public void createBookTest(Book book) {

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
