package com.ms.catalog.controller;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.CategoriesFormDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.service.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/categories",produces= "application/json")
public class CategoriesController {

    @Autowired
    private CategoriesServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriesDTO> save(@RequestBody CategoriesFormDTO body) {
        CategoriesDTO state = this.service.save(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping
    public ResponseEntity<List<CategoriesDTO>> list(){
        return ResponseEntity.ok(this.service.list());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoriesDTO> search (@RequestParam(value = "categories_id") String categories_id){
        return ResponseEntity.ok(this.service.search(categories_id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CategoriesDTO> delete(@RequestParam(value = "categories_id", required = true) String categories_id){
        this.service.delete(categories_id);
        return ResponseEntity.ok().build();
    }

    }
