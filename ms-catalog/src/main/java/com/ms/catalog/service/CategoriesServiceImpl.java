package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Products;
import com.ms.catalog.repository.CategoriesRepository;
import com.ms.catalog.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoriesDTO save(CategoriesFormDTO body) {
        Categories categories = mapper.map(body, Categories.class);
        Categories categoriesResponse = this.categoriesRepository.save(categories);
        return mapper.map(categoriesResponse, CategoriesDTO.class);
    }

    @Override
    public List<CategoriesDTO> list() {
        List<Categories> categories =  this.categoriesRepository.findAll();
        return categories.stream()
                .map(category -> mapper.map(category, CategoriesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductsDTO> searchForProducts(String id) {
        Optional<Categories> categories = this.categoriesRepository.findById(id);
        if (categories.isPresent()){
            List<Products> products = categories.get().getProducts();

            return products.stream()
                    .map(product -> mapper.map(product, ProductsDTO.class))
                    .collect(Collectors.toList());
        }
        throw new RuntimeException("Categoria não localizada");
    }

    @Override
    public CategoriesDTO search(String id) {
        Optional<Categories> categories = this.categoriesRepository.findById(id);
        if (categories.isPresent()){
            return mapper.map(categories.get(), CategoriesDTO.class);
        }
        throw new RuntimeException("Categoria não localizada");
    }



    @Override
    public CategoriesDTO update(String id, CategoriesFormDTO body) {
        Optional<Categories> categories = this.categoriesRepository.findById(id);
        if (categories.isPresent()) {
            Categories categoryToUpdate = mapper.map(body, Categories.class);
            categoryToUpdate.setId(id);
            Categories updatedCategory = categoriesRepository.save(categoryToUpdate);

            return mapper.map(updatedCategory, CategoriesDTO.class);
        }
        throw new RuntimeException("Categoria não encontrada");
    }

    @Override
    public void delete(String id) {
        Optional<Categories> categories = this.categoriesRepository.findById(id);
        if (categories.isPresent()) {
            categoriesRepository.deleteById(id);
        }
        throw new RuntimeException("Categoria não encontrada");
    }
}
