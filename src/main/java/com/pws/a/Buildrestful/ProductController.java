/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.a.Buildrestful;

import Modal.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    // pemanggilan getProdcut
    @RequestMapping("/products")
    //Method untuk mengambil data
    public ResponseEntity<Object> getProduct()
    {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    //menambahkan product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        //execption ketika createProduct menggunakan id yg telah dipakai
        if(productRepo.containsKey(product.getId()))
        {
            return new ResponseEntity<>("Product id already used", HttpStatus.OK);
        }
        else
        {
            //menyimpan product
            productRepo.put(product.getId(), product);
        
            //menampilkan status
            return new ResponseEntity<>("Product is created successfully",HttpStatus.CREATED);
        }
    }
    
    //memperbaharui data
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    
    //method untuk mengubah data berdasarkan id
    public ResponseEntity<Object> updateProduct (@PathVariable("id")String id, @RequestBody Product product)
    {
        //execption ketika mengubah data yg belum ada
        if (!productRepo.containsKey(id)) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            
        } else {
        //mengubah data berdasarkan id
        productRepo.remove(id);
        product.setId(id);
        
        //menyimpan data
        productRepo.put(id, product);
        
        //menampilkan status
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }
    }
    
    //menghapus data
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    
    //method untuk menghapus data
    public ResponseEntity<Object> deleteProduct(@PathVariable("id")String id)
    {
        //execption ketika menghapus data yg tdk ditemukan
        if(!productRepo.containsKey(id))
        {
            return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
        }
        else
        {
            //menghapus data by id
            productRepo.remove(id);
            return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }
        
    }
    
    
}
