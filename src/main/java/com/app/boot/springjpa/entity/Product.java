package com.app.boot.springjpa.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "product")
public class Product /**extends DateAudit**/{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idproduct;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @NotNull
    @Column(name = "stock", nullable = false)
    private int stock;

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;
}
