package org.example.library;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String description;
    private String author;
    private boolean isEBook;

    public Book(String title, String description, String author) {
        this(UUID.randomUUID().toString(), title, description, author, false);
    }

    public Book(String id, String title, String description, String author, boolean isEBook) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isEBook = isEBook;
    }

    public String getId() {
        return id;
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

    public boolean isEBook() {
        return isEBook;
    }

    public void setEBook(boolean EBook) {
        isEBook = EBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isEBook=" + isEBook +
                '}';
    }

}
