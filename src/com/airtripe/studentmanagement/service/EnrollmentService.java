package com.airtripe.studentmanagement.service;

import java.time.LocalDate;
import java.util.*;

import com.airtripe.studentmanagement.entity.Course;
import com.airtripe.studentmanagement.entity.Enrollment;
import com.airtripe.studentmanagement.entity.Student;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Student student, Course course, double grade) {
        Enrollment enrollment = new Enrollment(student, course, LocalDate.now(), grade);
        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }
}
