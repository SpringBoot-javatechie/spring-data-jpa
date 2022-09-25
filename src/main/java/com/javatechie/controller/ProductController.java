package com.javatechie.controller;

import com.javatechie.entity.Product;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    @GetMapping("/type/{productType}")
    public List<Product> getProductsByType(@PathVariable String productType) {
        return service.getProductsByType(productType);
    }

    @GetMapping("/price/{price}/type/{productType}")
    public List<Product> getProductWithPriceAndType(@PathVariable double price,@PathVariable String productType) {
        return service.getProductWithPriceAndType(price, productType);
    }

    @GetMapping("/search/{price}")
    public List<Product> getProductByPrice(@PathVariable double price) {
        return service.getProductsByPrice(price);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
       return service.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
