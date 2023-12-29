package com.example.CrudUsingJpa.dto;

public class RoleDTO {
    private String role_name;

    @Override
    public String toString() {
        return "RoleDTO{" +
                "role_name='" + role_name + '\'' +
                '}';
    }

    public RoleDTO() {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
