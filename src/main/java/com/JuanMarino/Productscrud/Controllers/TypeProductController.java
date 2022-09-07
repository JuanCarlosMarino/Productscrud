/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.Controllers;


import com.JuanMarino.Productscrud.models.TypeProductEntity;
import com.JuanMarino.Productscrud.services.TypeProductService;
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
@RequestMapping("/typeproducts")
public class TypeProductController {
    @Autowired
    private TypeProductService serviceTypeProducto;
    
    @GetMapping("/")
    public List<TypeProductEntity> consultAll(){
        return serviceTypeProducto.findAll();
    }
    
    @GetMapping("/{id}")
    public TypeProductEntity consultById(@PathVariable Integer id){
        return serviceTypeProducto.findById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<TypeProductEntity> add(@RequestBody TypeProductEntity typeProduct){
        TypeProductEntity record = serviceTypeProducto.save(typeProduct);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeProductEntity> delete(@PathVariable Integer id){
        TypeProductEntity foundRecord = serviceTypeProducto.findById(id);
        if (foundRecord != null){
            serviceTypeProducto.delete(id);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<TypeProductEntity> update(@RequestBody TypeProductEntity typeProduct){
        TypeProductEntity foundRecord = serviceTypeProducto.findById(typeProduct.getIdTypeProduct());
        if(foundRecord!=null){            
            foundRecord.setTypeProductName(typeProduct.getTypeProductName());
            serviceTypeProducto.save(typeProduct);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
}
