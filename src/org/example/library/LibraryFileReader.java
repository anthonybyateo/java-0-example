package org.example.library;

import org.example.library.resource.FileLoader;
import org.example.library.resource.FileName;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryFileReader {
    private static final String DELIMITER = ",";
    private FileLoader fileLoader;

    public LibraryFileReader(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    public List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        List<String> lines = readByLine(fileLoader.getFilePath(FileName.BOOK));
        for (String line : lines) {
            String[] sublines = line.split(DELIMITER);
            books.add(new Book(sublines[0], sublines[1], sublines[2], sublines[3], Boolean.parseBoolean(sublines[4])));
        }
        return books;
    }

    public List<User> readUsers() {
        List<User> users = new ArrayList<>();
        List<String> lines = readByLine(fileLoader.getFilePath(FileName.USER));
        for (String line : lines) {
            String[] sublines = line.split(DELIMITER);
            users.add(new User(sublines[0], sublines[1], sublines[2], Boolean.parseBoolean(sublines[3])));
        }
        return users;
    }

    private List<String> readByLine(String filePath) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
