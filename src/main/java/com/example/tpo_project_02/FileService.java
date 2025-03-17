package com.example.tpo_project_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class FileService {
    private final String filename;

    public FileService(@Value("${pl.edu.pja.tpo02.filename}") String filename) {
        this.filename = filename;
    }

    public void loadEntries(EntryRepository repository) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + filename);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        repository.addEntry(new Entry(parts[0], parts[1], parts[2]));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }
}
