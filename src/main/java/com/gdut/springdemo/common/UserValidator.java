package com.gdut.springdemo.common;

import com.gdut.springdemo.model.CustomUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Jun on 2016/9/11.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomUser user = (CustomUser)o;
        ValidationUtils.rejectIfEmpty(errors, "username", "username.required");
    }
}
