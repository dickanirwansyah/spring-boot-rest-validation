package com.app.boot.springjpa.validation.validator;

import com.app.boot.springjpa.entity.Product;
import com.app.boot.springjpa.repository.ProductRepository;
import com.app.boot.springjpa.request.RequestInsertProduct;
import com.app.boot.springjpa.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductValidator implements ConstraintValidator<ProductValidation,
        RequestInsertProduct> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(RequestInsertProduct value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        Product product = productRepository.findByIdproduct(value.getIdproduct());

        if(value.getName() == null || value.getName().isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("name is required")
                    .addPropertyNode("name").addConstraintViolation();
            return false;
        }

        if(value.getCategory() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("category is required")
                    .addPropertyNode("category").addConstraintViolation();
            return false;
        }

        if(value.getStock() == 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("stock is required")
                    .addPropertyNode("stock").addConstraintViolation();
            return false;
        }

        if(value.getPrice() == 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("price is required")
                    .addPropertyNode("price").addConstraintViolation();
            return false;
        }

        return true;
    }
}
