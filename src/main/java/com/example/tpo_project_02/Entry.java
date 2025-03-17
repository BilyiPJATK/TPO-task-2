package com.example.tpo_project_02;

public class Entry {
    private String polish;
    private String german;
    private String english;

    public Entry(String polish, String german, String english){
        this.polish = polish;
        this.german = german;
        this.english = english;
    }

    public String getEnglish() {
        return english;
    }

    public String getGerman() {
        return german;
    }

    public String getPolish() {
        return polish;
    }

    @Override
    public String toString(){
        return "[Polish: " + polish + ", German:" + german + ", English: " + english + "]";
    }
}