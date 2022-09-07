/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.Controllers;

import com.JuanMarino.Productscrud.models.UserEntity;
import com.JuanMarino.Productscrud.services.UserService;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService serviceUsero;
    
    @GetMapping("/")
    public List<UserEntity> consultAll(){
        return serviceUsero.findAll();
    }
    
    @GetMapping("/{id}")
    public UserEntity consultById(@PathVariable Integer id){
        return serviceUsero.findById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user){
        UserEntity record = serviceUsero.save(user);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable Integer id){
        UserEntity foundRecord = serviceUsero.findById(id);
        if (foundRecord != null){
            serviceUsero.delete(id);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity user){
        UserEntity foundRecord = serviceUsero.findById(user.getIdUser());
        if(foundRecord!=null){
            foundRecord.setUser(user.getUser());
            foundRecord.setPassword(user.getPassword());
            serviceUsero.save(user);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
}
