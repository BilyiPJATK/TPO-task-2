package com.example.tpo_project_02;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FleshCardsController {

    private EntryRepository entryRepository;
    private DisplayProfile displayProfile;

    public FleshCardsController(EntryRepository entryRepository, DisplayProfile displayProfile){
        this.displayProfile = displayProfile;
        this.entryRepository = entryRepository;
    }

    public void addEntry(Entry entry){
        entryRepository.addEntry(entry);
    }

    public void Test(){

        Scanner scanner = new Scanner(System.in);

        List<Entry> words = entryRepository.getEntries();
        if(words.isEmpty()) return;

        Entry nextWords = words.get(new Random().nextInt((words.size())));

        System.out.println("Translate: " + nextWords.getEnglish());

        System.out.println("Polish:");
        String userPolish = scanner.nextLine().toLowerCase().trim();

        System.out.println("German:");
        String userGerman = scanner.nextLine().toLowerCase().trim();

        if(Objects.equals(nextWords.getPolish(), userPolish)) System.out.println("Correct polish translation");
        else System.out.println("Incorrect polish translation! Correct answer: " + nextWords.getPolish());
        if(Objects.equals(nextWords.getGerman(), userGerman)) System.out.println("Correct german translation");
        else System.out.println("Incorrect german translation! Correct answer: " + nextWords.getGerman());

    }

    public void displayEntries() {
        System.out.println(entryRepository);
    }
}
