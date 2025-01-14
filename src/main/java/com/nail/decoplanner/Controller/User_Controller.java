package com.nail.decoplanner.Controller;

import com.nail.decoplanner.Entity.User;
import com.nail.decoplanner.Service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class User_Controller {

    private final UserService userService;

    public User_Controller(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @RequestMapping(value = "/updateUsername", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return ResponseEntity.ok("Username Updated: " + user.getUserId() );
    }
    @RequestMapping(value = "/updatePW", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updatePassword(@RequestBody User user) {
        return  ResponseEntity.ok("Password Updated");
    }

    @RequestMapping(value = "/updateEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmail(@RequestBody User user) {
        return  ResponseEntity.ok("Email Updated");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok("User Created!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("deleted = " + userId);
    }
}
