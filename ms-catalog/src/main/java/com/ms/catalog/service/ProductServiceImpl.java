package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
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
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductsDTO save(ProductsFormDTO body) {
        Products products = mapper.map(body, Products.class);
        Products productsResponse = this.productRepository.save(products);
        return mapper.map(productsResponse, ProductsDTO.class);
    }

    @Override
    public List<ProductsDTO> list() {
        List<Products> products =  this.productRepository.findAll();
        return products.stream()
                .map(category -> mapper.map(products, ProductsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductsDTO search(String id) {
        Optional<Products> products = this.productRepository.findById(id);
        if (products.isPresent()){
            return mapper.map(products.get(), ProductsDTO.class);
        }
        throw new RuntimeException("Produto não localizado");
    }

    @Override
    public ProductsDTO update(String id, ProductsFormDTO body) {
        Optional<Products> products = this.productRepository.findById(id);
        if (products.isPresent()) {
            Products productToUpdate = mapper.map(body, Products.class);
            productToUpdate.setId(id);
            Products updatedProduct = productRepository.save(productToUpdate);

            return mapper.map(updatedProduct, ProductsDTO.class);
        }
        throw new RuntimeException("Produto não localizado");
    }

    @Override
    public void delete(String id) {
        Optional<Products> products = this.productRepository.findById(id);
        if (products.isPresent()) {
            productRepository.deleteById(id);
        }
        throw new RuntimeException("Produto não localizado");

    }
}
