package com.xwitter_java.controllers;

import com.xwitter_java.models.UserIn;
import com.xwitter_java.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserIn> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserIn> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserIn saveUser(@RequestBody UserIn user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public UserIn updateUser(@PathVariable Long id, @RequestBody UserIn user) {
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
