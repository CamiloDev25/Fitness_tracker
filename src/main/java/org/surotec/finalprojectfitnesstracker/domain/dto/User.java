package org.surotec.finalprojectfitnesstracker.domain.dto;

public class User {

        private String name;
        private String lastName;
        private String email;
        private String password;
        private boolean isLogin = false;
        private String role;

    public User(String name, String lastName, String email, String password, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isLogin() {
        return isLogin;
    }

    @Override
    public String toString() {
        return email +  "," + password + "," + name + ","+ lastName + "," + role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
}

