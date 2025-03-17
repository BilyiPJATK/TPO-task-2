package com.example.tpo_project_02;

import java.util.List;

public class NormalProfile implements DisplayProfile {
    public void display(List<Entry> entries) {
        entries.forEach(System.out::println);
    }
}
