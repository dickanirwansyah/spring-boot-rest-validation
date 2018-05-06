package com.app.boot.springjpa.service;

import com.app.boot.springjpa.entity.Product;
import com.app.boot.springjpa.request.RequestInsertProduct;

import java.util.List;

public interface ProductService {

    Product createdProduct(RequestInsertProduct request);
    List<Product> listProduct();
}
