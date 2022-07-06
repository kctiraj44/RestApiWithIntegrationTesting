package com.example.springbootfull.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Product_Tbl")
public class Product  {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
}
