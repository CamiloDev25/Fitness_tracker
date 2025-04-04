package org.surotec.finalprojectfitnesstracker.domain.service.impl;
import org.surotec.finalprojectfitnesstracker.domain.dto.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class UserServiceImpl {

    private Map<String, User> users = new HashMap<>();
    private static final String EMAIL_ADMIN = "admin@fitness.com";
    private static final String PASSWORD_ADMIN = "Admin123";


    public static String getEmailAdmin(){
        return EMAIL_ADMIN;
    }

    public static String getPasswordAdmin(){
        return PASSWORD_ADMIN;
    }

    public UserServiceImpl() {
        // Agregar usuario administrador por defecto
        users.put(EMAIL_ADMIN, new User("Admin", "Admin", EMAIL_ADMIN, PASSWORD_ADMIN));
    }

    public void registerUser(String name, String lastName, String email, String password) throws Exception {
        validateEmail(email);

        if (users.containsKey(email)) {
            throw new Exception("The email address is already registered");
        }
        validatePassword(password);
        users.put(email, new User(name, lastName, email, password));
        System.out.println("Successful registration!");
    }

    public void logIn(String email, String password) throws Exception {
        validateEmail(email);
        User user = users.get(email);
        if (user == null) {
            throw new Exception("email not found.");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("The password is incorrect.");
        }
        System.out.println("Welcome, " + user.getName() + "!");

    }

    private void validateEmail(String email) throws Exception {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new Exception("Invalid email format. Please enter a valid email address.");
        }
    }

    private void validatePassword(String password) throws Exception {
        if (password.length() < 8) {
            throw new Exception("The password must be at least 8 characters long.");
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            throw new Exception("Password must contain at least one capital letter.");
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            throw new Exception("Password must contain at least one lowercase letter.");
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            throw new Exception("The password must contain at least one digit.");
        }
    }
    }




