package ru.stga.bookstore.tests.rest.model.request;
import lombok.*;
import lombok.experimental.Accessors;
import ru.stga.bookstore.tests.rest.enums.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
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

    public static Book defaultOf() {
        /*
        Статический конструктор, который создает книгу с предзаполненными параметрами
         */
        return new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);
    }

}
