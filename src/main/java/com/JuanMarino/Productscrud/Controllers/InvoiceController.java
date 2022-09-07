/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.Controllers;

import com.JuanMarino.Productscrud.models.InvoiceEntity;
import com.JuanMarino.Productscrud.services.InvoiceService;
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
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService serviceInvoiceo;
    
    @GetMapping("/")
    public List<InvoiceEntity> consultAll(){
        return serviceInvoiceo.findAll();
    }
    
    @GetMapping("/{id}")
    public InvoiceEntity consultById(@PathVariable Integer id){
        return serviceInvoiceo.findById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<InvoiceEntity> add(@RequestBody InvoiceEntity invoice){
        InvoiceEntity record = serviceInvoiceo.save(invoice);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceEntity> delete(@PathVariable Integer id){
        InvoiceEntity foundRecord = serviceInvoiceo.findById(id);
        if (foundRecord != null){
            serviceInvoiceo.delete(id);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<InvoiceEntity> update(@RequestBody InvoiceEntity invoice){
        InvoiceEntity foundRecord = serviceInvoiceo.findById(invoice.getIdInvoice());
        if(foundRecord!=null){
            foundRecord.setDate(invoice.getDate());
            foundRecord.setiDUsers(invoice.getiDUsers());            
            serviceInvoiceo.save(invoice);
        }
        return new ResponseEntity<>(foundRecord, HttpStatus.OK);
    }
}
