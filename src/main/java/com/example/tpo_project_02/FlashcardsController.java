package com.example.tpo_project_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Controller
public class FlashcardsController {
    private final EntryRepository repository;
    private final FileService fileService;
    private final DisplayProfile profile;

    public FlashcardsController(FileService fileService, @Value("${pl.edu.pja.tpo02.profile}") String profileName) {
        this.repository = new EntryRepository();
        this.fileService = fileService;

        // Load words from file
        fileService.loadEntries(repository);

        // Select profile based on YAML configuration
        switch (profileName) {
            case "Upper":
                this.profile = new UppercaseProfile();
                break;
            case "Lower":
                this.profile = new LowercaseProfile();
                break;
            default:
                this.profile = new NormalProfile();
                break;
        }
    }

    public void addEntry(String polish, String german, String english) {
        repository.addEntry(new Entry(polish, german, english));
    }

    public void displayEntries() {
        profile.display(repository.getEntries());
    }

    public void startTest() {
        Scanner scanner = new Scanner(System.in);

        List<Entry> words = repository.getEntries();
        if (words.isEmpty()) {
            System.out.println("No words available!");
            return;
        }

        Entry randomEntry = words.get(new Random().nextInt(words.size()));
        System.out.println("Translate: " + randomEntry.getEnglish());

        System.out.print("Polish: ");
        String userPolish = scanner.nextLine().trim().toLowerCase();

        System.out.print("German: ");
        String userGerman = scanner.nextLine().trim().toLowerCase();

        if (userPolish.equals(randomEntry.getPolish().toLowerCase()))
            System.out.println("Correct polish translation!");
        else
            System.out.println("Incorrect polish translation! Correct answer: " + randomEntry.getPolish());

        if (userGerman.equals(randomEntry.getGerman().toLowerCase()))
            System.out.println("Correct german translation!");
        else
            System.out.println("Incorrect german translation! Correct answer: " + randomEntry.getGerman());

    }
}
