package com.xwitter_java.controllers;

import com.xwitter_java.exceptions.UserNotFoundException;
import com.xwitter_java.models.UserIn;
import com.xwitter_java.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Validated
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
    public ResponseEntity<UserIn> saveUser(@RequestBody @Valid UserIn user) {
            return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody @Valid UserIn user) {
        // Переделать валидатор или добавить проверку
        // что если это тот же email или username то ничего не делать
        try {
            UserIn updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok().body(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
