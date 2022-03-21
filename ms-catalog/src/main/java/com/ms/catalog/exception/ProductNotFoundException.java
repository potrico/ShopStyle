package com.ms.catalog.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super(String.format("Produto de id %s nao existe", id));
    }
}
