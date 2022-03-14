package com.ms.catalog.controller;

import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
import com.ms.catalog.entity.Products;
import com.ms.catalog.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/products",produces= "application/json")
public class ProductsController {

    @Autowired
    private ProductServiceImpl service;

    @PostMapping
    public ResponseEntity<ProductsDTO> save(@RequestBody ProductsFormDTO body) {
        ProductsDTO products = this.service.save(body);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<Products>> list(){
        return ResponseEntity.ok(this.service.list());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductsDTO> search(@PathVariable String id){
        return ResponseEntity.ok(this.service.search(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductsDTO> update (@PathVariable(value = "products_id") String id, @RequestBody ProductsFormDTO body) {
        return ResponseEntity.ok(this.service.update(id, body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProductsDTO> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
