package com.app.boot.springjpa.validation.validator;

import com.app.boot.springjpa.request.RequestInsertCategory;
import com.app.boot.springjpa.validation.CategoryValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoryValidator implements ConstraintValidator<CategoryValidation, RequestInsertCategory> {


    @Override
    public void initialize(CategoryValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(RequestInsertCategory value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        if(value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Name is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if(value.getDescription() == null || value.getDescription().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Description is required")
                    .addPropertyNode("description").addConstraintViolation();
            return false;
        }

        return true;
    }
}
