/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.Controllers;


import com.JuanMarino.Productscrud.models.ProductsInvoiceEntity;
import com.JuanMarino.Productscrud.services.ProductsInvoiceService;
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
@RequestMapping("/productsinvoice")
public class ProductsInvoiceController {
    @Autowired
    private ProductsInvoiceService serviceProductsInvoiceo;
    
    @GetMapping("/")
    public List<ProductsInvoiceEntity> consultAll(){
        return serviceProductsInvoiceo.findAll();
    }
    
    @GetMapping("/{id}")
    public ProductsInvoiceEntity consultById(@PathVariable Integer id){
        return serviceProductsInvoiceo.findById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<ProductsInvoiceEntity> add(@RequestBody ProductsInvoiceEntity productInvoice){
        ProductsInvoiceEntity record = serviceProductsInvoiceo.save(productInvoice);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductsInvoiceEntity> delete(@PathVariable Integer id){
        ProductsInvoiceEntity foundRecord = serviceProductsInvoiceo.findById(id);
        if (foundRecord != null){
            serviceProductsInvoiceo.delete(id);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<ProductsInvoiceEntity> update(@RequestBody ProductsInvoiceEntity productInvoice){
        ProductsInvoiceEntity foundRecord = serviceProductsInvoiceo.findById(productInvoice.getIdProductsInvoice());
        if(foundRecord!=null){
            foundRecord.setAmount(productInvoice.getAmount());
            foundRecord.setIdProduct(productInvoice.getIdProduct());
            foundRecord.setIdInvoice(productInvoice.getIdInvoice());
            serviceProductsInvoiceo.save(productInvoice);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
}
