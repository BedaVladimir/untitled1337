package ru.stga.bookstore.tests.props;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Properties properties; // В переменной находится объект конфигурации

    public static Properties getConfiguration() {
        return getConfiguration("config.properties");
    }

    @SneakyThrows
    public static Properties getConfiguration(String filename) {
        /*
        метод для инициализации и возвращения переменной конфигурации
         */

        try (InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream(filename)) {

            if (inputStream == null) {
                throw new IllegalArgumentException("Unable to find " + filename);
            }

            properties = new Properties();
            properties.load(inputStream);
        }

        return properties;
    }
}
