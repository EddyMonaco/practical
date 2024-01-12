package com.cids.eduardo.controller;


import com.cids.eduardo.exception.ExceptionHandlerEx;
import com.cids.eduardo.model.DefaultError;
import com.cids.eduardo.model.Product;
import com.cids.eduardo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listAll() {

        return productService.listAll();
    }

    @GetMapping(value = "/{id}")
    public Product listById(@PathVariable Long id) {
        return productService.listByIdProduct(id);
    }

    @PutMapping(value = "/{id}")
    public Product editByIdProduct(@PathVariable Long id, @RequestBody Product product){
       return productService.editByIdProduct(id, product);
    }

    @PostMapping
    public Product addAProduct(@RequestBody Product product){
        return productService.addAProduct(product);
    }

    @GetMapping(value = "/bysupplier/{name}")
    public List<Product> listBySupplier(@PathVariable String name) throws UserPrincipalNotFoundException {
       return productService.listBySupplier(name);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteByIdProduct(id);
    }

    }
