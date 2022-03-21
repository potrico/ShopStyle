package com.ms.catalog.dto;

import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Variations;
import lombok.Data;

import java.util.List;

@Data
public class ProductsDTO {

    private String id;

    private String name;

    private String description;

    private Boolean active;

    private List<VariationsDTO> variations;
}
