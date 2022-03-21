package com.ms.catalog.dto;

import com.ms.catalog.entity.Categories;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductsFormDTO {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Boolean active;

    @NotNull
    private List<String> categories_ids;
}
