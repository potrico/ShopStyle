package com.ms.catalog.service;

import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import org.springframework.stereotype.Service;

@Service
public class VariationServiceImpl implements VariationService{
    @Override
    public VariationsDTO save(VariationsFormDTO body) {
        return null;
    }

    @Override
    public VariationsDTO update(String variation_id, VariationsFormDTO body) {
        return null;
    }

    @Override
    public void delete(String variation_id) {

    }
}
