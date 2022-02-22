package com.example.products.controllers;

import com.example.products.entities.Products;
import com.example.products.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductServices productServices;


    @GetMapping
    private ResponseEntity<Page<Products>> listAll(Pageable pageable){
        return new ResponseEntity<>(productServices.listAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Products> findById(@PathVariable Long id){
        return new ResponseEntity<>(productServices.findById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Products> addProducts(@RequestBody Products products){
        return new ResponseEntity<>(productServices.addProducts(products), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Products> update(@PathVariable Long id, @RequestBody Products products){
        Products p1 = productServices.update(id, products);
        return new ResponseEntity<>(p1, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        productServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
