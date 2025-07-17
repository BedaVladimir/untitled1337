package ru.stga.bookstore.tests.props;

public enum TestConfig {


    Uri("uri"),
    Path("path");

    public final String value;

    TestConfig(String value) {
        /*
        конструктор читает value, которая используется для чтения соответствующего значения из файла конфигурации.
        потом вызывается метод getConfiguration() из класса Configuration, который читает свойство из файла конфигурации по указанному ключу.
         */

        this.value = Configuration.getConfiguration().getProperty(value);
    }
}
