package com.example.tpo_project_02;

import java.util.List;

public class LowercaseProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(e -> System.out.println(e.toString().toLowerCase()));
    }
}
