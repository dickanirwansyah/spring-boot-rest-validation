package com.app.boot.springjpa.validation;

import com.app.boot.springjpa.validation.validator.CategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = {CategoryValidator.class})
@Documented
public @interface CategoryValidation {

    String message()
            default "CategoryValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
