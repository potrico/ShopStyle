package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Variations;
import com.ms.catalog.repository.CategoriesRepository;
import com.ms.catalog.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoriesDTO save(CategoriesFormDTO body) {
        Categories categories = mapper.map(body, Categories.class);
        Categories categoriesResponse = this.categoriesRepository.save(categories);
        return mapper.map(categoriesResponse, CategoriesDTO.class);
    }

    @Override
    public List<Categories> list() {
        return this.categoriesRepository.findAll();
    }

    @Override
    public CategoriesDTO searchForProducts(String categories_id) {
        return null;
    }

    @Override
    public CategoriesDTO search(String categories_id) {
        Optional<Categories> categories = this.categoriesRepository.findById(categories_id);
        if (categories.isPresent()){
            return mapper.map(categories.get(), CategoriesDTO.class);
        }
        throw new RuntimeException("Id incorreto");
    }


    @Override
    public CategoriesDTO update(String categories_id, CategoriesFormDTO body) {
        Optional<Categories> categories = this.categoriesRepository.findById(categories_id);
        if (categories.isPresent()) {
            Categories st = this.categoriesRepository.save(categories.get());
            return mapper.map(st, CategoriesDTO.class);
        }
        throw new RuntimeException("categoria não localizada");
    }

    @Override
    public void delete(String categories_id) {
        Categories categories = this.categoriesRepository.findById(categories_id).get();
        this.categoriesRepository.delete(categories);
    }
}
