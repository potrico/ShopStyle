package com.ms.catalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Variations {

    @Id
    private String variation_id;

    private String color;

    private String size;

    private double price;

    private int quantity;

    private Products product_id;
}
