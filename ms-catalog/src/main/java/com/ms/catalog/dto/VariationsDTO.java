package com.ms.catalog.dto;

import com.ms.catalog.entity.Products;
import lombok.Data;

@Data
public class VariationsDTO {

    private String variation_id;

    private String color;

    private String size;

    private double price;

    private int quantity;

    private Products product_id;
}
