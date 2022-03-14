package com.ms.catalog.service;

import com.ms.catalog.dto.CategoriesDTO;
import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Variations;
import com.ms.catalog.repository.VariationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VariationServiceImpl implements VariationService{
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private VariationsRepository variationsRepository;

    @Override
    public VariationsDTO save(VariationsFormDTO body) {
        Variations variations = mapper.map(body, Variations.class);
        Variations variationsResponse = this.variationsRepository.save(variations);
        return mapper.map(variationsResponse, VariationsDTO.class);
    }

    @Override
    public VariationsDTO update(String variation_id, VariationsFormDTO body) {
        Optional<Variations> variation = this.variationsRepository.findById(variation_id);
        if (variation.isPresent()) {
            Variations st = this.variationsRepository.save(variation.get());
            return mapper.map(st, VariationsDTO.class);
        }
            throw new RuntimeException("Variação não localizada");
    }

    @Override
    public void delete(String variation_id) {
        Variations variations = this.variationsRepository.findById(variation_id).get();
        this.variationsRepository.delete(variations);
    }
}
