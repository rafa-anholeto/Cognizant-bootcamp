package com.example.products.services;

import com.example.products.entities.Products;
import com.example.products.repositories.ProductsRepository;
import com.example.products.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductsRepository productsRepository;

    public Page<Products> listAll(Pageable pageable){
        return productsRepository.findAll(pageable);
    }

    public Products findById(Long id){
        Optional<Products> obj = productsRepository.findById(id);
        return productsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Products addProducts(Products products){
        return productsRepository.save(products);
    }

    public Products update(Long id, Products products){
        productsRepository.findById(products.getId()).get();
        products.setId(products.getId());
        products.setName(products.getName());
        products.setPrice(products.getPrice());
        return productsRepository.save(products);
    }

    public void delete(Long id){
        productsRepository.deleteById(id);
    }
}
