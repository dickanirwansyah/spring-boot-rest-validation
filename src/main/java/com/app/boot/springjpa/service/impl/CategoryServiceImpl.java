package com.app.boot.springjpa.service.impl;

import com.app.boot.springjpa.entity.Category;
import com.app.boot.springjpa.repository.CategoryRepository;
import com.app.boot.springjpa.request.RequestInsertCategory;
import com.app.boot.springjpa.request.RequestUpdateCategory;
import com.app.boot.springjpa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createdCategory(RequestInsertCategory request) {

        String idcategory = request.getIdcategory();
        boolean valid = false;
        Category category = null;

        if(idcategory == null){
             category = new
                    Category(request.getName(),
                     request.getDescription());
            categoryRepository.save(category);
        }
        return category;
    }

    @Override
    public Category updatedCategory(RequestUpdateCategory request) {

        String idcategory = request.getIdcategory();
        boolean valid = false;
        Category category = null;

        if(idcategory != null){
            category = categoryRepository.findByIdcategory(category.getIdcategory());
            valid = true;
        }
        category.setIdcategory(request.getIdcategory());
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return category;
    }

    @Override
    public List<Category> listCategory() {
        List<Category> categories = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            categories.add(category);
        }
        return categories;
    }
}
