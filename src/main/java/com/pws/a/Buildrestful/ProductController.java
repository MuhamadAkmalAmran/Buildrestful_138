/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.a.Buildrestful;

import Modal.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author akmal
 */
//Digunakan untuk mendefinisikan RESTful 
@RestController
public class ProductController {
    //method untuk menyimpan class Product
    private static Map<String, Product> productRepo = new HashMap<>();
    static
    {
        //membuat pemanggilan class product
        Product honey = new Product();
        
        //Menambahkan data
        honey.setId("1");
        honey.setName("Honey");
        
        //Menyimpan data
        productRepo.put(honey.getId(),honey);
    }
    
}
