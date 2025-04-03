package org.surotec.finalprojectfitnesstracker.domain.dto;

public class User {
    //clase para representar a los usuarios (pensar si la hago statica)
    private String firsName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;

    public User(String firstName, String lastName, String email, String password, boolean isAdmin) {
        this.firsName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {

        return firsName;
    }

    public void setFirstName(String firsName) {

        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
