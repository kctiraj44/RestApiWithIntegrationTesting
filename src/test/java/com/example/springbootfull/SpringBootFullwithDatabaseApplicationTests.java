package com.example.springbootfull;

import com.example.springbootfull.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootFullwithDatabaseApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    private TestOracleRepository oracleRepository;

    private String baseUrl = "http://localhost";


    private static RestTemplate restTemplate;

    @BeforeAll
    public static  void init(){
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp(){
        baseUrl = baseUrl.concat(":").concat(port+"").concat("/pro");
    }

//     Test to add
    @Test
    public void testAddProduct(){
        Product product = new Product(56,"Raj","KC");
       Product response =  restTemplate.postForObject(baseUrl,product,Product.class);  //  running
        assertEquals("Raj",response.getName());
        assertEquals(1 ,oracleRepository.findAll().size());
    }


    //Test to Fetch all
    @Test
    @Sql(statements = "INSERT INTO Product_Tbl (id,name) VALUES (34,'AC')",executionPhase =Sql.ExecutionPhase.BEFORE_TEST_METHOD )
    @Sql(statements = "DELETE FROM Product_Tbl WHERE name ='AC'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testToFetchALL(){
       List<Product> response = restTemplate.getForObject(baseUrl,List.class); // running
       assertEquals(1,oracleRepository.findAll().size());
    }


    //Test to fetch by id
    @Test
    @Sql(statements = "INSERT INTO Product_Tbl (id,name) VALUES (1,'AC')",executionPhase =Sql.ExecutionPhase.BEFORE_TEST_METHOD )
    @Sql(statements = "DELETE FROM Product_Tbl WHERE name ='AC'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getByProduct(){
        Product product = restTemplate.getForObject(baseUrl+"/{id}",Product.class,1); //running
       assertEquals(1,product.getId());
    }


    //update Product
    @Test
    @Sql(statements = "INSERT INTO Product_Tbl (id,name) VALUES (2,'AC')",executionPhase =Sql.ExecutionPhase.BEFORE_TEST_METHOD )
    @Sql(statements = "DELETE FROM Product_Tbl WHERE name ='AC'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void updateProduct(){
        Product product = new Product(2,"Raj","kc");
        restTemplate.put(baseUrl+"/{id}",product,2);
      Product productDB=  oracleRepository.findById(2).get();
      assertAll(
              ()->assertNotNull(productDB),                               // running
              ()->assertEquals("Raj",productDB.getName())
      );

    }

//delete Test
    @Test
    @Sql(statements = "INSERT INTO Product_Tbl (id,name) VALUES (3,'AC')",executionPhase =Sql.ExecutionPhase.BEFORE_TEST_METHOD )
    public void deleteProduct(){
     int recordCount =   oracleRepository.findAll().size();
     assertEquals(1,recordCount);
     restTemplate.delete(baseUrl+"/{id}",3);          //running
     assertEquals(0,oracleRepository.findAll().size());


    }





}
