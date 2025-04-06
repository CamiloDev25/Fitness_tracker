package org.surotec.finalprojectfitnesstracker.domain.dto;

public class User {

        private String name;
        private String lastName;
        private String email;
        private String password;
        private boolean isLogin;
        private String role;

    public User(String name, String lastName, String email, String password, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return email +  "," + password + "," + name + ","+ lastName + "," + role;
    }
}

