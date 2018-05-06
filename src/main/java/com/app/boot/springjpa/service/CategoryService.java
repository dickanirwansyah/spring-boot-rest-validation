package com.app.boot.springjpa.service;

import com.app.boot.springjpa.entity.Category;
import com.app.boot.springjpa.request.RequestInsertCategory;
import com.app.boot.springjpa.request.RequestUpdateCategory;

import java.util.List;

public interface CategoryService {

    Category createdCategory(RequestInsertCategory request);
    Category updatedCategory(RequestUpdateCategory request);
    List<Category> listCategory();
}
