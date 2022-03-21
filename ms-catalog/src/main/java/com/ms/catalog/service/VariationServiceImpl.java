package com.ms.catalog.service;

import com.ms.catalog.dto.VariationsDTO;
import com.ms.catalog.dto.VariationsFormDTO;
import com.ms.catalog.entity.Categories;
import com.ms.catalog.entity.Products;
import com.ms.catalog.entity.Variations;
import com.ms.catalog.exception.ProductNotFoundException;
import com.ms.catalog.repository.ProductRepository;
import com.ms.catalog.repository.VariationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VariationServiceImpl implements VariationService{


    @Autowired
    private VariationsRepository variationsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VariationsDTO save(VariationsFormDTO body) {
        String productId = body.getProduct_id();
        Products product = productVerification(productId);
        Variations variationToCreate = mapper.map(body, Variations.class);
        Variations createdVariation = variationsRepository.save(variationToCreate);
        product.getVariations().add(createdVariation);
        productRepository.save(product);
        return mapper.map(createdVariation, VariationsDTO.class);
    }

    @Override
    public VariationsDTO update(String id, VariationsFormDTO body) {
        Optional<Variations> variations = this.variationsRepository.findById(id);
        if (variations.isPresent()) {
            String productId = body.getProduct_id();
            productVerification(productId);
            Variations variationToUpdate = mapper.map(body, Variations.class);
            variationToUpdate.setId(id);
            Variations updatedVariation = variationsRepository.save(variationToUpdate);
            return mapper.map(updatedVariation, VariationsDTO.class);
        }
        throw new RuntimeException("Variação não encontrada");
    }

    @Override
    public void delete(String id) {
        Optional<Variations> variations = this.variationsRepository.findById(id);
        if (variations.isPresent()) {
            variationsRepository.deleteById(id);
        }
        throw new RuntimeException("Variação não encontrada");
    }

    private Products productVerification(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
