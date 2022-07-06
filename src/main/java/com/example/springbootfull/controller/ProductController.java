package com.example.springbootfull.controller;

import com.example.springbootfull.entity.Product;
import com.example.springbootfull.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping()
    public Product  createProduct(@RequestBody Product product){
        service.addProduct(product);
        return  product;
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable int id){
        Product product = service.getByItem(id);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id){
        service.deleteProduct(id);
        return "*--Successfully Deleted--*";
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable int id){
       return service.updateProduct(product,id);

    }

}
