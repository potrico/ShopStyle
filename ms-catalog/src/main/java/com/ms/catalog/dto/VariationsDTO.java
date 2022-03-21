package com.ms.catalog.dto;

import com.ms.catalog.entity.Products;
import lombok.Data;

@Data
public class VariationsDTO {

    private String id;

    private String color;

    private String size;

    private double price;

    private int quantity;

}
