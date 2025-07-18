package ru.stga.bookstore.tests.rest.model.response;

import lombok.*;
import ru.stga.bookstore.tests.rest.model.request.Book;

import java.time.OffsetDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BookResponse extends Book {
    /*
    Класс отвечает за десериализацию тела ответа API-методов для добавления, чтения и обновления книг
     */

    private Integer id;
    private OffsetDateTime lastUpdated;


}
