package com.airtripe.studentmanagement.entity;

import java.time.LocalDate;

public class GraduateStudent extends Student {

    private String thesisTitle;
    private String advisorName;

    public GraduateStudent() {
        super();
    }

    public GraduateStudent(int id, String name, String email, String phone, char gender,
                           boolean active, String studentId, LocalDate enrollmentDate, double gpa,
                           String thesisTitle, String advisorName) {
        super(id, name, email, phone, gender, active, studentId, enrollmentDate, gpa);
        this.thesisTitle = thesisTitle;
        this.advisorName = advisorName;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    @Override
    public String getProfile() {
        return "Graduate Student: " + getName() + " (" + getStudentId() + "), Thesis: " + thesisTitle;
    }
}
