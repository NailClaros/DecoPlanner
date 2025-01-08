package com.nail.decoplanner.domain.user;

import com.nail.decoplanner.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
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

//    public User updateUser(String userId, User userDetails) {
//        User user = getUserById(userId);
//        user.setUsername(userDetails.getUsername());
//        user.setPassword(userDetails.getPassword());
//        user.setEmail(userDetails.getEmail());
//        return userRepository.save(user);
//    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
