package com.example.tpo_project_02;

import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("Normal")
public class NormalProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(System.out::println);
    }
}
