package org.example.library;

import org.example.library.resource.FileLoader;
import org.example.library.resource.FileName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LibraryFileWriter {
    private FileLoader fileLoader;

    public LibraryFileWriter(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public void writeToBooks(Book book) {
        final String bookStr = "%s,%s,%s,%s,%s".formatted(
                book.getId(), book.getTitle(), book.getDescription(), book.getAuthor(), book.isEBook()
        );
        writeLine(bookStr, fileLoader.getFile(FileName.BOOK));
    }

    public void writeToUsers(User user) {
        final String userStr = "%s,%s,%s,%s".formatted(
                user.getId(), user.getEmail(), user.getPasswordHash(), user.isAdmin()
        );
        writeLine(userStr, fileLoader.getFile(FileName.USER));
    }

    private void writeLine(String value, File file) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("\n%s".formatted(value));
        } catch (IOException e) {
            System.out.printf("File %s doesn't exist", file.getName());
        }
    }

}
