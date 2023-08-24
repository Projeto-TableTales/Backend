package com.tabletale.rpgwiki.domain.entity;

public enum UserRole {
    ADMIN("mestre"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}