package com.xwitter_java.constraints;

import com.xwitter_java.validators.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {

    String message() default "Пользователь с таким email уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
