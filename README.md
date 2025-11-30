Student Management System (Java Console Application)

A fully object-oriented Java-based Student Management System that demonstrates core Java concepts including OOP, inheritance, interfaces, collections, file handling, custom exceptions, and basic AI-powered features.
This project was created as part of an academic assignment and follows all required directives including JVM architecture understanding, setup documentation, and bonus feature implementations.

⭐ Features
🎓 Student Management

Add new students

View all students

Update GPA

Search students (by ID or name)

Delete students

Persistent storage using CSV (students.csv)

📘 Course & Enrollment Management

Predefined course list

Add new courses

Enroll students into courses

View all enrollments

🤖 AI Helper Features (Bonus)

Auto-grade student assignments (simple NLP keyword scoring)

Recommend courses based on GPA

Basic sentiment analysis (POSITIVE / NEGATIVE / NEUTRAL)

🧱 Folder Structure
student-management-system/
│
├── src/
│   └── com/
│       └── airtripe/
│           └── studentmanagement/
│               ├── Main.java
│               ├── entity/
│               │   ├── Person.java
│               │   ├── Student.java
│               │   ├── GraduateStudent.java
│               │   ├── Course.java
│               │   └── Enrollment.java
│               ├── service/
│               │   ├── StudentService.java
│               │   ├── CourseService.java
│               │   └── EnrollmentService.java
│               ├── interfaces/
│               │   ├── Searchable.java
│               │   └── Gradeable.java
│               ├── util/
│               │   ├── InputValidator.java
│               │   ├── DateUtil.java
│               │   └── AIHelper.java
│               └── exception/
│                   ├── StudentNotFoundException.java
│                   └── InvalidDataException.java
│
├── docs/
│   ├── JVM_Architecture_Report.md
│   ├── Setup_Instructions.md
│   └── API_Documentation.md
│
└── students.csv   (auto-created on first run)

🛠️ Technologies Used

Java 17+

VS Code (Java Extensions Pack)

Java Collections Framework

File I/O (BufferedReader, BufferedWriter)

Object-Oriented Programming

Custom Exceptions

CSV persistence

AI Helper (Rule-based NLP)

🚀 How to Run the Project (Terminal)
1. Navigate to the project directory
cd student-management-system

2. Compile the project
cd src
find . -name "*.java" > sources.txt
javac @sources.txt

3. Run the program
java com.airtripe.studentmanagement.Main


You will see:

=== Student Management System ===
1. Add Student
2. View Students
3. Update GPA
4. Delete Student
5. Search Student
6. AI Features
0. Exit

📄 Documentation

All assignment-required documents are included in the docs/ folder:

✔ JVM_Architecture_Report.md

JVM components diagram

JIT vs Interpreter explanation

Bytecode execution

WORA principle

✔ Setup_Instructions.md

JDK installation

VS Code setup

Environment variables

Screenshots required

✔ API_Documentation.md

Explanation of classes, services, methods, and flows

🧪 Testing (Optional)

A test folder is included for adding JUnit tests:

src/test/java/


You may add:

StudentServiceTest.java

CourseServiceTest.java

Integration tests

👨‍💻 Author

Student: Your Name
Project: Student Management System
Language: Java

💡 Future Enhancements

Convert into a GUI application

Add database support (MySQL/PostgreSQL)

Implement user roles (Admin/Teacher/Student)

Add REST API using Spring Boot
