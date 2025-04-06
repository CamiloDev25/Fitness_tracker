package org.surotec.finalprojectfitnesstracker.infraestructure.repository;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserRepository implements IUserRepository {

    private String fileName = "user.txt";

    @Override
    public User save(User user) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // true = modo append
            writer.write(user.toString() + "\n");
            System.out.println("User saved Succesfuly.");
            return user;
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User find(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String emailInFile = data[0];
                String passwordInFile = data[1];
                String nameInFile = data[2];
                String lastNameInFile = data[3];
                String roleInFile = data[4];

                if (emailInFile.equalsIgnoreCase(email)) {
                    return new User(nameInFile, lastNameInFile, emailInFile, passwordInFile, roleInFile);
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
            return null;
        }
        return null;
    }
}