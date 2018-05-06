package com.app.boot.springjpa.validation;

import com.app.boot.springjpa.validation.validator.ProductValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Documented
@Constraint(validatedBy = {
        ProductValidator.class
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductValidation {

    String message()
            default "ProductValidation";

    Class<?>[] groups()
            default {};

    Class<? extends Payload>[] payload()
            default {};

    String[] path()
            default {};
}
