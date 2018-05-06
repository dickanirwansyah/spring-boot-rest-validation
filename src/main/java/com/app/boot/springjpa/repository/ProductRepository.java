package com.app.boot.springjpa.repository;

import com.app.boot.springjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Product findByIdproduct(String idproduct);
}
