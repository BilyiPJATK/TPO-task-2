package com.example.tpo_project_02;

import org.springframework.beans.factory.annotation.Value;

import java.util.Scanner;

public class FlashcardsApp {

    public static void main(String[] args) {

        EntryRepository repository = new EntryRepository();

        FileService.loadEntries(repository);

        FileService fileService = ;

        DisplayProfile profile = new NormalProfile();

        FleshCardsController controller = new FleshCardsController(repository, profile);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add word\n2. Show words\n3. Start test\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Polish: ");
                    String polish = scanner.nextLine();
                    System.out.print("English: ");
                    String english = scanner.nextLine();
                    System.out.print("German: ");
                    String german = scanner.nextLine();
                    controller.addEntry(new Entry(polish, german, english));
                    break;
                case 2:
                    controller.displayEntries();
                    break;
                case 3:
                    controller.Test();
                    break;
                case 4:
                    return;
            }

        }
    }
}
