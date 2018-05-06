package com.app.boot.springjpa.controller;

import com.app.boot.springjpa.entity.Product;
import com.app.boot.springjpa.exception.ApiResponse;
import com.app.boot.springjpa.request.RequestInsertProduct;
import com.app.boot.springjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/created")
    public ResponseEntity<Product> createdProduct(@Valid @RequestBody RequestInsertProduct request){
        return Optional.ofNullable(productService.createdProduct(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        return Optional.ofNullable(productService.listProduct())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handlerException(MethodArgumentNotValidException exception){

        String errorMessage = exception.getBindingResult()
                .getFieldErrors().stream().map(
                        DefaultMessageSourceResolvable::getDefaultMessage
                ).findFirst().orElse(exception.getMessage());

        return ApiResponse.builder().message(errorMessage).build();
    }
}
