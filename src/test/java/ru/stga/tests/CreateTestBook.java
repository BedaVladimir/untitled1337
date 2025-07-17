package ru.stga.tests;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import ru.stga.bookstore.tests.rest.client.TestClient;
import ru.stga.bookstore.tests.rest.enums.Category;
import ru.stga.bookstore.tests.rest.model.request.Book;


public class CreateTestBook {

    @Test
    public void createBookTest() {

        Book book = new Book("The Adventures of Tom Sawyer", "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);

        TestClient testClient = new TestClient();

        testClient.create(book).assertThat(). //блок then() отвечает за проверки
                statusCode(201).
                body("id", Matchers.notNullValue()).
                body("author", Matchers.equalTo("Mark Twain")).
                body("category", Matchers.equalTo("Adventures")).
                body("count", Matchers.equalTo(10)).
                body("description", Matchers.equalTo("The story about Tom Sawyer.")).
                body("price", Matchers.equalTo(350)).
                body("title", Matchers.equalTo("The Adventures of Tom Sawyer")).
                log().all();
}

}
