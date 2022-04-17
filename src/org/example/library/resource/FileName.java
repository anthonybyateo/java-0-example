package org.example.library.resource;

import java.util.ArrayList;
import java.util.List;

public enum FileName {
    BOOK("book.txt"),
    USER("user.txt");

    private String name;

    FileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
        List<String> fileNames = new ArrayList<>();
        for (FileName fileName: FileName.values()) {
            fileNames.add(fileName.getName());
        }
        return fileNames;
    }

}
