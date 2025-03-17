package com.example.tpo_project_02;

import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("Lower")
public class LowercaseProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(e -> System.out.println(e.toString().toLowerCase()));
    }
}
