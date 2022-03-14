package com.ms.catalog.service;

import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductsDTO save(ProductsFormDTO body) {
        return null;
    }

    @Override
    public List<ProductsDTO> list() {
        return null;
    }

    @Override
    public ProductsDTO search(String product_id) {
        return null;
    }

    @Override
    public ProductsDTO update(String product_id, ProductsFormDTO body) {
        return null;
    }

    @Override
    public void delete(String product_id) {

    }
}
