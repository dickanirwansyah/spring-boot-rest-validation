package com.app.boot.springjpa.request;

import com.app.boot.springjpa.validation.CategoryValidation;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@CategoryValidation
public class RequestInsertCategory {

    private String idcategory;

    private String name;

    private String description;
}
