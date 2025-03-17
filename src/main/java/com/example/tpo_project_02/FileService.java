package com.example.tpo_project_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;


@Service
@ConfigurationProperties(prefix="pl.edu.pja.tpo02")

public class FileService {
    @Value("$filename")  String filename;

    public

    public static void loadEntries(EntryRepository repository) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    repository.addEntry(new Entry(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
