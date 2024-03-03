package com.xwitter_java.controllers;

import com.xwitter_java.models.UserIn;
import com.xwitter_java.services.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserIn user) {
        try {
            if (userService.existsByUsername(user.getUsername())) {
                List<String> errorMessages = new ArrayList<>();
                errorMessages.add("Пользователь с таким именем уже существует.");
                return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
            }
            if (userService.existsByEmail(user.getEmail())) {
                List<String> errorMessages = new ArrayList<>();
                errorMessages.add("Пользователь с таким адресом электронной почты уже существует.");
                return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
            }
            UserIn savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add("Ошибка при сохранении пользователя.");
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
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
