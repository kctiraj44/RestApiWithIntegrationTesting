package com.example.springbootfull;

import com.example.springbootfull.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOracleRepository  extends JpaRepository<Product,Integer> {
}
