package org.example.library;

import org.example.library.db.FileLoader;
import org.example.library.db.FileName;

import java.io.BufferedWriter;
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
        writeLine(bookStr, fileLoader.getFilePath(FileName.BOOK));
    }

    public void writeToUsers(User user) {
        final String userStr = "%s,%s,%s,%s".formatted(
                user.getId(), user.getEmail(), user.getPasswordHash(), user.isAdmin()
        );
        writeLine(userStr, fileLoader.getFilePath(FileName.USER));
    }

    private void writeLine(String value, String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append("\n%s".formatted(value));
            writer.flush();
        } catch (IOException e) {
            System.out.printf("File %s doesn't exist", filePath);
        }
    }

}
