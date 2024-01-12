package com.cids.eduardo.service;

import com.cids.eduardo.model.Product;
import com.cids.eduardo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> listAll(){
        return productRepository.findAll();
    }
    public Product listByIdProduct(Long id){

        Product product = productRepository.findById(id).orElseGet(Product::new);
        if(product.getName() == null){
            System.out.println("Product was not found by id: "+ id);
            return product;
        }
        return product;
    }

    public void deleteByIdProduct(Long id){

        Product existingProduct = productRepository.findById(id).orElseGet(Product::new);

        if(existingProduct.getName() != null) {
            productRepository.deleteById(id);
            System.out.println("Product: "+ existingProduct.getName() + " deleted.");
        }
    }

    public Product editByIdProduct(Long id, Product product){

        Product existingProduct = productRepository.findById(id).orElseGet(Product::new);
        System.out.println(existingProduct.getId() + " " + id);

        if( existingProduct.getId() != id) {
            return existingProduct;
        }
        else{

            if(product.getName() != null ){
                existingProduct.setName(product.getName());}

            if(product.getQuantity() >= 0){
                existingProduct.setQuantity(product.getQuantity());}

            if(product.getSupplier() != null){
                existingProduct.setSupplier(product.getSupplier());}


            return productRepository.save(existingProduct);
        }
    }

    public Product addAProduct(Product product){

            Product productBody = productRepository.save(product);
            return productBody;

    }

    public List<Product> listBySupplier(String name){

        List<Product> bySupplier = (List<Product>) productRepository.findAll()
                                                                    .stream()
                                                                    .filter(supplier -> supplier.getSupplier().getName().equals(name))
                                                                    .collect(Collectors.toList());;
        return bySupplier;
    }


}
