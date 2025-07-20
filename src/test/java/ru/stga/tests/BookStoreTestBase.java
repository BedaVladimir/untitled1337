package ru.stga.tests;

import ru.stga.bookstore.tests.rest.client.TestClient;

public class BookStoreTestBase {

    protected static TestClient testClient; // Чтобы не создавать новый объект тест клиента для отправки запросов в каждом автотесте

    static {
        testClient = new TestClient();
    }
}
