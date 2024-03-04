package com.xwitter_java.constraints;

import com.xwitter_java.validators.UniqueUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface UniqueUsername {

    String message() default "Пользователь с таким именем уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
