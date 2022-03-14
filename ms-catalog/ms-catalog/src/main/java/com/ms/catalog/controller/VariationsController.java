package com.ms.catalog.controller;

import com.ms.catalog.dto.ProductsDTO;
import com.ms.catalog.dto.ProductsFormDTO;
import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import com.ms.catalog.service.ProductServiceImpl;
import com.ms.catalog.service.VariationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/variations",produces= "application/json")
public class VariationsController {

    @Autowired
    private VariationServiceImpl service;

    @PostMapping
    public ResponseEntity<VariationsDTO> save(@RequestBody VariationsFormDTO body) {
        VariationsDTO variations = this.service.save(body);
        return ResponseEntity.ok(variations);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VariationsDTO> update (@PathVariable(value = "variations_id") String id, @RequestBody VariationsFormDTO body) {
        return ResponseEntity.ok(this.service.update(id, body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<VariationsDTO> delete(@PathVariable String id){
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
