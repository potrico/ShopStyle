package com.ms.catalog.controller;

import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
import com.ms.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductsController {

    @Autowired
    private ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsDTO create(@RequestBody ProductsFormDTO body) {
        return service.save(body);
    }

    @GetMapping
    public List<ProductsDTO> findAll() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ProductsDTO findById(@PathVariable String id) {
        return service.search(id);
    }

    @PutMapping("/{id}")
    public ProductsDTO update(@PathVariable String id, @RequestBody ProductsFormDTO body) {
        return service.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
