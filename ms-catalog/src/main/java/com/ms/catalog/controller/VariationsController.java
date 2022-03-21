package com.ms.catalog.controller;

import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import com.ms.catalog.service.VariationService;
import com.ms.catalog.service.VariationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/variations")
public class VariationsController {

    @Autowired
    private VariationServiceImpl service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VariationsDTO create(@RequestBody VariationsFormDTO variationRequestDTO) {
        return service.save(variationRequestDTO);
    }

    @PutMapping("/{id}")
    public VariationsDTO update(@PathVariable String id, @RequestBody VariationsFormDTO variationRequestDTO) {
        return service.update(id, variationRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
