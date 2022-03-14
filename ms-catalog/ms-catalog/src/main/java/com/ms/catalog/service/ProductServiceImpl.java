package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Products;
import com.ms.catalog.entity.Variations;
import com.ms.catalog.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productsRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductsDTO save(ProductsFormDTO body) {
        Products products = mapper.map(body, Products.class);
        Products productsResponse = this.productsRepository.save(products);
        return mapper.map(productsResponse, ProductsDTO.class);
    }

    @Override
    public List<Products> list() {
        return this.productsRepository.findAll();
    }

    @Override
    public ProductsDTO search(String product_id) {
        Optional<Products> products = this.productsRepository.findById(product_id);
        if (products.isPresent()){
            return mapper.map(products.get(), ProductsDTO.class);
        }
        throw new RuntimeException("Id incorreto");
    }


    @Override
    public ProductsDTO update(String product_id, ProductsFormDTO body) {
        Optional<Products> products = this.productsRepository.findById(product_id);
        if (products.isPresent()) {
            Products st = this.productsRepository.save(products.get());
            return mapper.map(st, ProductsDTO.class);
        }
        throw new RuntimeException("Produto não localizado");
    }

    @Override
    public void delete(String product_id) {
        Products products = this.productsRepository.findById(product_id).get();
        this.productsRepository.delete(products);
    }

}
