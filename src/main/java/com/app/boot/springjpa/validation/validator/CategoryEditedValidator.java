package com.app.boot.springjpa.validation.validator;

import com.app.boot.springjpa.request.RequestUpdateCategory;
import com.app.boot.springjpa.validation.CategoryEditedValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CategoryEditedValidator implements ConstraintValidator<CategoryEditedValidation,
        RequestUpdateCategory> {

    @Override
    public void initialize(CategoryEditedValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(RequestUpdateCategory value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        if(value.getIdcategory() == null || value.getIdcategory().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Id category is required")
                    .addPropertyNode("idcategory").addConstraintViolation();
            return false;
        }

        if(value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if(value.getDescription() == null || value.getDescription().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("description is required")
                    .addPropertyNode("description").addConstraintViolation();
            return false;
        }

        return true;
    }
}
