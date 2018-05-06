package com.app.boot.springjpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category /**extends DateAudit**/{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idcategory;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    public Category(){}

    public Category(String name, String description){
        this.name = name;
        this.description = description;
    }

}
