package com.airtripe.studentmanagement.entity;

public class Course {

    private int id;
    private String code;
    private String title;
    private int credits; // primitive int

    public Course(int id, String code, String title, int credits) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}
