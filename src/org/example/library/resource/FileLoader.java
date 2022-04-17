package org.example.library.resource;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {
    private Map<FileName, File> files;

    public FileLoader() {
        this.files = new HashMap<>();
        loadFiles();
    }

    private void loadFiles() {
        for (FileName fileName : FileName.values()) {
            URL url = getClass().getResource(fileName.getName());
            File file = new File(url.getPath());
            this.files.put(fileName, file);
        }
    }

    public File getFile(FileName fileName) {
        return files.get(fileName);
    }

}
