package com.example.tpo_project_02;

import java.util.ArrayList;
import java.util.List;

public class EntryRepository {
    private List<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Entry entry : entries){
            result.append(entry);
        }
        return result.toString();
    }
}

