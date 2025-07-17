package ru.stga.bookstore.tests.rest.model.request;
import ru.stga.bookstore.tests.rest.enums.Category;

public class Book {

    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;

    public Book(String title, String description, String author, Integer price, Integer count, Category category) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Category category;

}
