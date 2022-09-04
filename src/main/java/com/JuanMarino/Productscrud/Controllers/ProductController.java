/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.Controllers;

import com.JuanMarino.Productscrud.models.ProductEntity;
import com.JuanMarino.Productscrud.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService serviceProducto;
    
    @GetMapping("/")
    public List<ProductEntity> consultAll(){
        return serviceProducto.findAll();
    }
    
    @GetMapping("/{id}")
    public ProductEntity consultById(@PathVariable Integer id){
        return serviceProducto.findById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<ProductEntity> add(@RequestBody ProductEntity product){
        ProductEntity record = serviceProducto.save(product);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductEntity> delete(@PathVariable Integer id){
        ProductEntity foundRecord = serviceProducto.findById(id);
        if (foundRecord != null){
            serviceProducto.delete(id);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity product){
        ProductEntity foundRecord = serviceProducto.findById(product.getIdProduct());
        if(foundRecord!=null){
            foundRecord.setProductName(product.getProductName());
            foundRecord.setPurchaseValue(product.getPurchaseValue());
            foundRecord.setSaleValue(product.getSaleValue());
            foundRecord.setAmount(product.getAmount());
            serviceProducto.save(product);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
}
