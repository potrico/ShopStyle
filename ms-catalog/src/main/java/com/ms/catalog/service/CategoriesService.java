package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.entity.Categories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoriesService {

    CategoriesDTO save(CategoriesFormDTO body);

    List<CategoriesDTO> list();

    List<ProductsDTO> searchForProducts(String id);

    CategoriesDTO search(String id);

    CategoriesDTO update(String id, CategoriesFormDTO body);

    void delete(String id);
}
