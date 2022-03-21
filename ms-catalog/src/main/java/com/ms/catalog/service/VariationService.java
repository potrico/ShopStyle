package com.ms.catalog.service;

import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import org.springframework.stereotype.Component;

@Component
public interface VariationService {

    VariationsDTO save(VariationsFormDTO body);

    VariationsDTO update(String id, VariationsFormDTO body);

    void delete(String variation_id);

}
