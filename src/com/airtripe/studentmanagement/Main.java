package com.airtripe.studentmanagement;

import java.time.LocalDate;
import java.util.List;

import com.airtripe.studentmanagement.entity.Student;
import com.airtripe.studentmanagement.entity.GraduateStudent;
import com.airtripe.studentmanagement.entity.Course;
import com.airtripe.studentmanagement.exception.InvalidDataException;
import com.airtripe.studentmanagement.exception.StudentNotFoundException;
import com.airtripe.studentmanagement.service.StudentService;
import com.airtripe.studentmanagement.service.CourseService;
import com.airtripe.studentmanagement.service.EnrollmentService;
import com.airtripe.studentmanagement.util.InputValidator;
import com.airtripe.studentmanagement.util.DateUtil;
import com.airtripe.studentmanagement.util.AIHelper;

public class Main {

    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        showJvmAndDataTypeDemo();  // for assignment requirements

        while (true) {
            printMenu();
            int choice = InputValidator.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> addStudentFlow();
                case 2 -> viewStudentsFlow();
                case 3 -> updateStudentFlow();
                case 4 -> deleteStudentFlow();
                case 5 -> searchStudentFlow();
                case 6 -> aiFeaturesFlow();
                case 0 -> {
                    System.out.println("Exiting... Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student GPA");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student");
        System.out.println("6. AI Features (Auto grade / Recommendations)");
        System.out.println("0. Exit");
    }

    // --- Requirement: Data type & JVM / variable demo ---
    private static void showJvmAndDataTypeDemo() {
        System.out.println("JVM Demo: Write Once, Run Anywhere (see docs for full report).");

        // primitive data types demo
        byte b = 10;
        short s = 200;
        int i = 1000;
        long l = 100000L;
        float f = 10.5f;
        double d = 20.99;
        char c = 'A';
        boolean flag = true;

        // implicit casting
        double implicit = i;  // int -> double

        // explicit casting
        int explicit = (int) d;  // double -> int

        System.out.println("Primitives: " + b + "," + s + "," + i + "," + l + "," + f + "," + d + "," + c + "," + flag);
        System.out.println("Implicit cast (int->double): " + implicit);
        System.out.println("Explicit cast (double->int): " + explicit);

        // Polymorphism demo
        Student s1 = new Student("Alice", "S001");
        GraduateStudent g1 = new GraduateStudent();
        g1.setStudentId("G001");
        g1.setName("Bob Grad");

        // runtime polymorphism: Person reference to Student/GraduateStudent
        System.out.println("Polymorphism demo:");
        System.out.println(s1.getProfile());
        System.out.println(g1.getProfile());
    }

    // --- Menu flows ---

    private static void addStudentFlow() {
        try {
            String name = InputValidator.readNonEmptyString("Name: ");
            String email = InputValidator.readNonEmptyString("Email: ");
            String phone = InputValidator.readNonEmptyString("Phone: ");
            String studentId = InputValidator.readNonEmptyString("Student ID: ");
            String dateStr = InputValidator.readNonEmptyString("Enrollment date (yyyy-MM-dd): ");
            double gpa = InputValidator.readDouble("GPA: ");
            char gender = 'U';

            LocalDate date = DateUtil.parseDate(dateStr);

            Student student = new Student(0, name, email, phone, gender, true, studentId, date, gpa);
            studentService.addStudent(student);
            System.out.println("Student added.");
        } catch (InvalidDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudentsFlow() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("=== Students ===");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudentFlow() {
        try {
            String studentId = InputValidator.readNonEmptyString("Student ID to update: ");
            double newGpa = InputValidator.readDouble("New GPA: ");
            studentService.updateStudentGpa(studentId, newGpa);
            System.out.println("GPA updated.");
        } catch (InvalidDataException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudentFlow() {
        try {
            String studentId = InputValidator.readNonEmptyString("Student ID to delete: ");
            studentService.deleteStudent(studentId);
            System.out.println("Student deleted.");
        } catch (InvalidDataException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudentFlow() {
        try {
            System.out.println("1. Search by ID");
            System.out.println("2. Search by name");
            int option = InputValidator.readInt("Choose search option: ");

            if (option == 1) {
                String studentId = InputValidator.readNonEmptyString("Student ID: ");
                Student s = studentService.findByStudentId(studentId);
                System.out.println("Found: " + s);
            } else if (option == 2) {
                String name = InputValidator.readNonEmptyString("Name keyword: ");
                List<Student> result = studentService.findByName(name);
                if (result.isEmpty()) {
                    System.out.println("No student found.");
                } else {
                    System.out.println("Found:");
                    for (Student s : result) {
                        System.out.println(s);
                    }
                }
            } else {
                System.out.println("Invalid option.");
            }
        } catch (InvalidDataException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void aiFeaturesFlow() {
        System.out.println("1. Auto-grade assignment");
        System.out.println("2. Course recommendations for a student");
        int option = InputValidator.readInt("Choose AI option: ");

        try {
            if (option == 1) {
                String text = InputValidator.readNonEmptyString("Paste assignment text: ");
                double grade = AIHelper.autoGrade(text);
                System.out.println("Auto-graded score: " + grade);
            } else if (option == 2) {
                String studentId = InputValidator.readNonEmptyString("Student ID: ");
                Student s = studentService.findByStudentId(studentId);
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> recommended = AIHelper.recommendCourses(s, allCourses);

                System.out.println("Recommended courses:");
                for (Course c : recommended) {
                    System.out.println(c);
                }
            } else {
                System.out.println("Invalid option.");
            }
        } catch (InvalidDataException | StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
