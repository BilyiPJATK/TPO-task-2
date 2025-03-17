package com.example.tpo_project_02;

import org.springframework.context.annotation.Profile;

import java.util.List;


@Profile("Upper")
public class UppercaseProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(entry -> System.out.println(entry.toString().toUpperCase()));
    }
}
