package com.airtripe.studentmanagement.entity;

import java.time.LocalDate;

public class Enrollment {

    private Student student;
    private Course course;
    private LocalDate enrolledOn;
    private double grade;

    public Enrollment(Student student, Course course, LocalDate enrolledOn, double grade) {
        this.student = student;
        this.course = course;
        this.enrolledOn = enrolledOn;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrolledOn() {
        return enrolledOn;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return student.getName() + " -> " + course.getCode() + " (" + grade + ")";
    }
}
