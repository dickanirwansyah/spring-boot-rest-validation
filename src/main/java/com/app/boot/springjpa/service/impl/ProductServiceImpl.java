package com.app.boot.springjpa.service.impl;

import com.app.boot.springjpa.entity.Product;
import com.app.boot.springjpa.repository.ProductRepository;
import com.app.boot.springjpa.request.RequestInsertProduct;
import com.app.boot.springjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createdProduct(RequestInsertProduct request) {
        String idproduct = request.getIdproduct();
        boolean valid = false;
        Product product = null;

        if(idproduct == null){
            product = new Product();
            valid = true;
        }
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.findAll()){
            productList.add(product);
        }
        return productList;
    }
}
