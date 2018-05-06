package com.app.boot.springjpa.request;

import com.app.boot.springjpa.validation.CategoryEditedValidation;
import lombok.Builder;
import lombok.Data;
;

@Data
@Builder
@CategoryEditedValidation
public class RequestUpdateCategory{

    private String idcategory;
    private String name;
    private String description;

}
