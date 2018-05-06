package com.app.boot.springjpa.controller;

import com.app.boot.springjpa.entity.Category;
import com.app.boot.springjpa.exception.ApiResponse;
import com.app.boot.springjpa.request.RequestInsertCategory;
import com.app.boot.springjpa.request.RequestUpdateCategory;
import com.app.boot.springjpa.service.CategoryService;
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
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.listCategory())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/created")
    public ResponseEntity<Category> createdCategory(@Valid @RequestBody RequestInsertCategory request){
        return Optional.ofNullable(categoryService.createdCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/updated")
    public ResponseEntity<Category> updatedCategory(@Valid @RequestBody RequestUpdateCategory request){
        return Optional.ofNullable(categoryService.updatedCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
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
