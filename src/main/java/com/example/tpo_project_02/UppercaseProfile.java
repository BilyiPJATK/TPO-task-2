package com.example.tpo_project_02;

import java.util.List;

public class UppercaseProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(entry -> System.out.println(entry.toString().toUpperCase()));
    }
}
