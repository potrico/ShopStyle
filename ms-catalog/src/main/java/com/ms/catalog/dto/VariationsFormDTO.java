package com.ms.catalog.dto;

import com.ms.catalog.entity.Products;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class VariationsFormDTO {

    @NotNull
    private String color;

    @NotNull
    private String size;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    @NotNull
    private String product_id;
}
