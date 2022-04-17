package org.example.library;

import java.util.List;

public class Catalog {
    private List<Book> books;
    private List<User> users;

    public Catalog() {
        FileReader fileReader = new FileReader();
        this.books = fileReader.readBooks();
        this.users = fileReader.readUsers();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }

}
