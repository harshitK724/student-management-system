package com.airtripe.studentmanagement.util;

import java.util.*;
import com.airtripe.studentmanagement.entity.Student;
import com.airtripe.studentmanagement.entity.Course;

public class AIHelper {

    public static double autoGrade(String assignmentText) {
        if (assignmentText == null || assignmentText.isEmpty()) {
            return 0.0;
        }
        String lower = assignmentText.toLowerCase();
        int score = 0;

        if (lower.contains("oop")) score += 10;
        if (lower.contains("inheritance")) score += 10;
        if (lower.contains("polymorphism")) score += 10;
        if (lower.contains("encapsulation")) score += 10;
        if (lower.contains("abstraction")) score += 10;

        // Cap at 50, scale to 100
        if (score > 50) score = 50;
        return (score / 50.0) * 100.0;
    }

    public static List<Course> recommendCourses(Student student, List<Course> allCourses) {
        List<Course> recommended = new ArrayList<>();
        double gpa = student.getGpa();

        for (Course course : allCourses) {
            if (gpa >= 8.0 && course.getCredits() >= 3) {
                recommended.add(course);
            } else if (gpa < 8.0 && course.getCredits() <= 3) {
                recommended.add(course);
            }
        }
        return recommended;
    }

    public static String analyzeSentiment(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return "NEUTRAL";
        }
        String lower = feedback.toLowerCase();
        int score = 0;
        if (lower.contains("good") || lower.contains("great") || lower.contains("love")) score++;
        if (lower.contains("bad") || lower.contains("hate") || lower.contains("terrible")) score--;

        if (score > 0) return "POSITIVE";
        if (score < 0) return "NEGATIVE";
        return "NEUTRAL";
    }
}
