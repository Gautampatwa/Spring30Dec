package com.example.CrudUsingJpa.dto;

public enum EmployeeRole {
    NORMAL(1, "NORMAL"),
    ADMIN(2, "ADMIN"),
    OPERATOR(3, "OPERATOR");

    private final int value;
    private final String roleName;

    EmployeeRole(int value, String roleName) {
        this.value = value;
        this.roleName = roleName;
    }

    public int getValue() {
        return value;
    }

    public String getRoleName() {
        return roleName;
    }

    public static EmployeeRole valueOf(int value) {
        for (EmployeeRole userRole : values()) {
            if (userRole.value == value) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole value: " + value);
    }

}
