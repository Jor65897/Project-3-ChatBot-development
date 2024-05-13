package za.ac.cput.service;

import za.ac.cput.domain.Users;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<Users> users;

    public AuthService() {
        this.users = new ArrayList<>();
    }

    public boolean register(String username, String password, String studentNumber, String email) {
        for (Users user : users) {
            if (user.getUsername().equals(username)) {
                return false; // User already exists
            }
        }

        users.add(new Users(username, password, studentNumber, email));
        return true; // User successfully registered
    }

    public boolean login(String username, String password) {
        for (Users user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Successful login
            }
        }

        return false;
    }

}
