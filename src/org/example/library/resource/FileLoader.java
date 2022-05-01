package org.example.library.resource;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// todo: move to real resource
public class FileLoader {
    private Map<FileName, String> filePaths;

    public FileLoader() {
        this.filePaths = new HashMap<>();
        loadFiles();
    }

    private void loadFiles() {
        for (FileName fileName : FileName.values()) {
            URL url = getClass().getResource(fileName.getName());
            this.filePaths.put(fileName, url.getPath());
        }
    }

    public String getFilePath(FileName fileName) {
        return filePaths.get(fileName);
    }

}
