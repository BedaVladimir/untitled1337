package ru.stga.bookstore.tests.rest.model.response;

import lombok.*;
import lombok.experimental.Accessors;
import ru.stga.bookstore.tests.rest.model.request.Book;

import java.time.OffsetDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
public class BookResponse extends Book {
    /*
    Класс отвечает за десериализацию тела ответа API-методов для добавления, чтения и обновления книг
     */
    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer id;
    private Integer status;
    private OffsetDateTime lastUpdated;
    private String error;
    private String path;

    public static BookResponse createError400() {
        return new BookResponse().setStatus(400).
                setError("Bad Request").
                setPath("/rest-api/books");
    }

}
