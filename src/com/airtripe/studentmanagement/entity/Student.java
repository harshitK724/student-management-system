package com.airtripe.studentmanagement.entity;

import java.time.LocalDate;
import com.airtripe.studentmanagement.interfaces.Searchable;
import com.airtripe.studentmanagement.interfaces.Gradeable;

public class Student extends Person implements Searchable, Gradeable {

    private String studentId;
    private LocalDate enrollmentDate;
    private double gpa;      // primitive double
    private static int count = 0; // static variable (class-level)

    // Default constructor
    public Student() {
        super();
        count++;
    }

    // Parameterized constructor (constructor chaining with super)
    public Student(int id, String name, String email, String phone, char gender,
                   boolean active, String studentId, LocalDate enrollmentDate, double gpa) {
        super(id, name, email, phone, gender, active);
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.gpa = gpa;
        count++;
    }

    // Copy constructor
    public Student(Student other) {
        super(other);
        this.studentId = other.studentId;
        this.enrollmentDate = other.enrollmentDate;
        this.gpa = other.gpa;
        count++;
    }

    // Overloaded constructor (compile-time polymorphism)
    public Student(String name, String studentId) {
        this(0, name, "", "", 'U', true, studentId, LocalDate.now(), 0.0);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String getProfile() {
        return "Student: " + getName() + " (" + studentId + "), GPA: " + gpa;
    }

    @Override
    public boolean matches(String keyword) {
        if (keyword == null) return false;
        String lower = keyword.toLowerCase();
        return (getName() != null && getName().toLowerCase().contains(lower))
                || (studentId != null && studentId.toLowerCase().contains(lower));
    }

    @Override
    public double calculateGrade() {
        return gpa * 10; // Just a simple function: GPA 8.0 => 80
    }

    @Override
    public String toString() {
        return getProfile();
    }
}
