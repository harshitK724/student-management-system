package com.airtripe.studentmanagement.entity;

public abstract class Person {

    // Demonstrate primitive types and access modifiers
    private int id;
    private String name;
    private String email;
    protected String phone;      // protected example
    public char gender;          // public example (not best practice, but for access modifier demo)
    private boolean active;      // primitive boolean

    // Default constructor
    public Person() {
        this.active = true;
    }

    // Parameterized constructor
    public Person(int id, String name, String email, String phone, char gender, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.active = active;
    }

    // Copy constructor
    public Person(Person other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.phone = other.phone;
        this.gender = other.gender;
        this.active = other.active;
    }

    // Getters & setters (Encapsulation)
    public int getId() {
        return id;
    }

    public void setId(int id) {  // method overriding candidate in subclasses if needed
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Abstract method (Abstraction)
    public abstract String getProfile();
}
