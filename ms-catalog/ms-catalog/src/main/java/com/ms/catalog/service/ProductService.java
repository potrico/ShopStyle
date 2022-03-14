package com.ms.catalog.service;

import com.ms.catalog.dto.*;
import com.ms.catalog.entity.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {


    ProductsDTO save(ProductsFormDTO body);

    List<Products> list();

    ProductsDTO search(String product_id);

    ProductsDTO update(String product_id, ProductsFormDTO body);

    void delete(String product_id);
}
