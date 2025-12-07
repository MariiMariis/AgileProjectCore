package com.agile.domain;

public class User {
    private String name;
    private String email;
    // Composição: User TEM UM Role, ao invés de SER um Role
    private UserRole role;

    public User(String name, String email, UserRole role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public UserRole getRole() { return role; }
}