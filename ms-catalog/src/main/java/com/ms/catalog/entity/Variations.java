package com.ms.catalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "variations")
public class Variations {

    @Id
    private String id;

    private String color;

    private String size;

    private double price;

    private int quantity;


}
