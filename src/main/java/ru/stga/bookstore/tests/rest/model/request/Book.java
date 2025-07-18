package ru.stga.bookstore.tests.rest.model.request;
import lombok.*;
import ru.stga.bookstore.tests.rest.enums.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;
    private Category category;

    public Book(Book book) {
        this.title = book.title;
        this.description = book.description;
        this.author = book.author;
        this.price = book.price;
        this.count = book.count;
        this.category = book.category;
    }

}
