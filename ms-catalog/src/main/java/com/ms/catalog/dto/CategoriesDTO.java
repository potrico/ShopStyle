package com.ms.catalog.dto;

import lombok.Data;

@Data
public class CategoriesDTO {

    private String category_id;

    private String name;

    private boolean active;
}
