package com.ms.catalog.controller;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.service.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/categories",produces= "application/json")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl service;

    @PostMapping
    public ResponseEntity<CategoriesDTO> save(@RequestBody CategoriesFormDTO body) {
        CategoriesDTO state = this.service.save(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping
    public ResponseEntity<List<Categories>> list(){
        return ResponseEntity.ok(this.service.list());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriesDTO> search(@PathVariable String id){
        return ResponseEntity.ok(this.service.search(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CategoriesDTO> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    }
