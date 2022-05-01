package org.example.library;

import org.example.library.db.FileLoader;
import org.example.library.db.LibraryFileReader;
import org.example.library.db.LibraryFileWriter;

import java.util.List;

public class Catalog {
    private final List<Book> books;
    private final List<User> users;
    private User currentUser;
    private LibraryFileWriter libraryFileWriter;

    public Catalog() {
        final FileLoader fileLoader = new FileLoader();
        final LibraryFileReader libraryFileReader = new LibraryFileReader(fileLoader);
        this.books = libraryFileReader.readBooks();
        this.users = libraryFileReader.readUsers();
        this.libraryFileWriter = new LibraryFileWriter(fileLoader);
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

    public User createUser(String email, String password) {
        final User user = new User(email, password);
        users.add(user);
        this.libraryFileWriter.writeToUsers(user);
        return user;
    }

    public void createBook(String title, String description, String author) {
        final Book book = new Book(title, description, author);
        books.add(book);
        this.libraryFileWriter.writeToBooks(book);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }

}
