package com.gdut.springdemo.common;

import com.gdut.springdemo.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jun on 2016/9/11.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User)o;
        ValidationUtils.rejectIfEmpty(errors, "username", "username.required");
    }
}
