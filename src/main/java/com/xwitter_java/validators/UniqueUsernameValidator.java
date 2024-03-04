package com.xwitter_java.validators;

import com.xwitter_java.constraints.UniqueUsername;
import com.xwitter_java.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UniqueUsernameValidator() {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository == null || !userRepository.existsByUsername(username);
    }

}
