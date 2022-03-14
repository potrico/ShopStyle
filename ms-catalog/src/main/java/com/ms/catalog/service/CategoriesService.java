package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.entity.Categories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoriesService {

    CategoriesDTO save(CategoriesFormDTO body);

    List<Categories> list();

    CategoriesDTO searchForProducts(String categories_id);

    CategoriesDTO search(String categories_id);

    CategoriesDTO update(String categories_id, CategoriesFormDTO body);

    void delete(String categories_id);
}
