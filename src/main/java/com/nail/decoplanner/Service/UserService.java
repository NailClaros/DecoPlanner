package com.nail.decoplanner.Service;

import com.nail.decoplanner.Entity.User;
import com.nail.decoplanner.Dao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID userId) {
        System.out.println("Getting user by id: " + userId);
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void testDatabaseConnection() {
        User newUser = new User("testuser", "password123", "testuser@example.com");
        userRepository.save(newUser);

        System.out.println("User saved successfully! - testuser");
    }

    public String updateUserN(User user) {
        User users = getUserById(user.getUserId());
        users.setUsername(user.getUsername());
        userRepository.save(users);
        System.out.println("Username updated successfully!");
        return users.getUsername();
    }
    public String updateUserE(User user) {
        User users = getUserById(user.getUserId());
        users.setEmail(user.getEmail());
        userRepository.save(users);
        return "Email updated";
    }
    public String updateUserP(User user) {
        User users = getUserById(user.getUserId());
        users.setPassword(user.getPassword());
        userRepository.save(users);
        return "Password updated";
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
        System.out.println("User deleted successfully!");
    }
}
