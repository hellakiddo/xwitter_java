package com.xwitter_java.validators;

import com.xwitter_java.constraints.UniqueEmail;
import com.xwitter_java.repositories.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UniqueEmailValidator() {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userRepository == null || !userRepository.existsByEmail(email);
    }
}
