package com.nail.decoplanner.api.user;

import com.nail.decoplanner.domain.user.User;
import com.nail.decoplanner.domain.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

//    @PutMapping("/{userId}")
//    public ResponseEntity<User> updateUser(
//            @PathVariable String userId, @RequestBody User userDetails) {
//        return ResponseEntity.ok(userService.updateUser(userId, userDetails));
//    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
