package com.app.boot.springjpa.repository;

import com.app.boot.springjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

    Category findByIdcategory(String idcategory);
}
