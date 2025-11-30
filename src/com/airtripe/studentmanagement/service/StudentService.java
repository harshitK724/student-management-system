package com.airtripe.studentmanagement.service;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import com.airtripe.studentmanagement.entity.Student;
import com.airtripe.studentmanagement.exception.StudentNotFoundException;
import com.airtripe.studentmanagement.util.DateUtil;

public class StudentService {

    private List<Student> students = new ArrayList<>();
    private static final String DATA_FILE = "students.csv";

    public StudentService() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    // Overloaded find methods (compile-time polymorphism)
    public Student findByStudentId(String studentId) throws StudentNotFoundException {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
    }

    public List<Student> findByName(String name) {
        List<Student> matches = new ArrayList<>();
        for (Student s : students) {
            if (s.getName() != null && s.getName().toLowerCase().contains(name.toLowerCase())) {
                matches.add(s);
            }
        }
        return matches;
    }

    public void updateStudentGpa(String studentId, double newGpa) throws StudentNotFoundException {
        Student s = findByStudentId(studentId);
        s.setGpa(newGpa);
        saveToFile();
    }

    public void deleteStudent(String studentId) throws StudentNotFoundException {
        Student s = findByStudentId(studentId);
        students.remove(s);
        saveToFile();
    }

    private void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            students.clear();
            while ((line = br.readLine()) != null) {
                // id,name,email,phone,gender,active,studentId,enrollmentDate,gpa
                String[] parts = line.split(",");
                if (parts.length != 9) continue;

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                String phone = parts[3];
                char gender = parts[4].charAt(0);
                boolean active = Boolean.parseBoolean(parts[5]);
                String studentId = parts[6];
                LocalDate enrollmentDate = DateUtil.parseDate(parts[7]);
                double gpa = Double.parseDouble(parts[8]);

                Student s = new Student(id, name, email, phone, gender, active, studentId, enrollmentDate, gpa);
                students.add(s);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Student s : students) {
                String line = String.join(",",
                        String.valueOf(s.getId()),
                        s.getName(),
                        s.getEmail(),
                        s.getPhone(),
                        String.valueOf(s.getGender()),
                        String.valueOf(s.isActive()),
                        s.getStudentId(),
                        DateUtil.formatDate(s.getEnrollmentDate()),
                        String.valueOf(s.getGpa())
                );
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}
