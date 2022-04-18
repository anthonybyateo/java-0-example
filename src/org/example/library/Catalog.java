package org.example.library;

import java.util.List;

public class Catalog {
    private final List<Book> books;
    private final List<User> users;
    private User currentUser;

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

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }

}
