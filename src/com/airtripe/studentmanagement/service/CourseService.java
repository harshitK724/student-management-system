package com.airtripe.studentmanagement.service;

import java.util.*;
import com.airtripe.studentmanagement.entity.Course;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public CourseService() {
        // Seed some default courses
        courses.add(new Course(1, "CS101", "Intro to Programming", 3));
        courses.add(new Course(2, "CS201", "Data Structures", 4));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(courses);
    }

    public Course findByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}
