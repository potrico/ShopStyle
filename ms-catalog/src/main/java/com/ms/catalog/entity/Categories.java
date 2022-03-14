package com.ms.catalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Categories {

    @Id
    private String category_id;

    private String name;

    private boolean active;
}
