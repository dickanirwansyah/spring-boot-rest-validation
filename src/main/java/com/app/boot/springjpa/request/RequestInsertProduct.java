package com.app.boot.springjpa.request;

import com.app.boot.springjpa.entity.Category;
import com.app.boot.springjpa.validation.ProductValidation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ProductValidation
public class RequestInsertProduct {

    private String idproduct;
    private String name;
    private Category category;
    private int stock;
    private Long price;
}
