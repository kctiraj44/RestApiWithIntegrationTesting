package com.example.springbootfull.service;

import com.example.springbootfull.entity.Product;
import com.example.springbootfull.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


//    @PostConstruct
//    public void insertIntoDB(){
//        List<Product> list = Arrays.asList(
//                new Product(89,"Ram"),
//                new Product(65,"shyam")
//        );
//        repository.saveAll(list);
//    }

    public List<Product>  getAll(){
     List<Product> products =    repository.findAll();
        return products;
    }


    public Product getByItem(int id){
        Product product = repository.findById(id).get();
        return product;
    }


    public Product addProduct(Product product){
        repository.save(product);
        return product;
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "*--Successfully Deleted--*";
    }

    public Product updateProduct(Product product){
        repository.save(product);
        return product;
    }

}
