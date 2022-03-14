package com.ms.catalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Products {

    @Id
    private String product_id;

    private String name;

    private String description;

    private boolean active;

    private List<Categories> category_ids;
}
