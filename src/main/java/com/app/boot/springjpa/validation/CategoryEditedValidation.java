package com.app.boot.springjpa.validation;

import com.app.boot.springjpa.validation.validator.CategoryEditedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {
        CategoryEditedValidator.class
})
@Documented
public @interface CategoryEditedValidation {

    String message()
            default "CategoryEditedValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
