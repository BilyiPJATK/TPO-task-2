package com.example.tpo_project_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class FlashcardsApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);

        FlashcardsController controller = context.getBean(FlashcardsController.class);

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
                    controller.addEntry(polish, german, english);
                    break;
                case 2:
                    controller.displayEntries();
                    break;
                case 3:
                    controller.startTest();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
