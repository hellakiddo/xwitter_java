package com.xwitter_java.services;

import com.xwitter_java.exceptions.UserNotFoundException;
import com.xwitter_java.models.UserIn;
import com.xwitter_java.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserIn> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserIn> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserIn saveUser(UserIn user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public UserIn updateUser(Long id, UserIn updatedUser) {
        Optional<UserIn> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            UserIn existingUser = optionalUser.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setFirst_name(updatedUser.getFirst_name());
            existingUser.setLast_name(updatedUser.getLast_name());
            return userRepository.save(existingUser);
        } else {
            throw new UserNotFoundException("Такой пользователь не найден");
        }
    }
}
