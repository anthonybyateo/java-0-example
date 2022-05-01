package org.example.library.db;

import java.util.HashMap;
import java.util.Map;

// todo: Rewrite the class to build jar.
public class FileLoader {
    private static final String RESOURCES_ABSOLUTE_PATH_FORMAT;

    static {
        RESOURCES_ABSOLUTE_PATH_FORMAT = "INSERT_YOUR_PATH\\src\\main\\resources\\library\\%s";
    }

    private Map<FileName, String> filePaths;

    public FileLoader() {
        this.filePaths = new HashMap<>();
        for (FileName fileName : FileName.values()) {
            this.filePaths.put(fileName, RESOURCES_ABSOLUTE_PATH_FORMAT.formatted(fileName.getName()));
        }
    }

    public String getFilePath(FileName fileName) {
        return filePaths.get(fileName);
    }

}
