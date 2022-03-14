package com.ms.catalog.dto;

import com.ms.catalog.entity.Categories;
import lombok.Data;

import java.util.List;

@Data
public class ProductsDTO {

    private String product_id;

    private String name;

    private String description;

    private boolean active;

    private List<Categories> category_ids;
}
