/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.services.impl;

import com.JuanMarino.Productscrud.dao.ProductsInvoiceDao;
import com.JuanMarino.Productscrud.models.ProductsInvoiceEntity;
import com.JuanMarino.Productscrud.services.ProductsInvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ProductsInvoiceServiceImp implements ProductsInvoiceService{
    
    @Autowired
    private ProductsInvoiceDao repositoryProductsInvoice;

    @Override
    @Transactional(readOnly = false)
    public ProductsInvoiceEntity save(ProductsInvoiceEntity product) {
        return repositoryProductsInvoice.save(product);
    }

    @Override
    public void delete(Integer id) {
        repositoryProductsInvoice.deleteById(id);
    }

    @Override
    public ProductsInvoiceEntity findById(Integer id) {
        return repositoryProductsInvoice.findById(id).orElse(null);
    }

    @Override
    public List<ProductsInvoiceEntity> findAll() {
        return(List<ProductsInvoiceEntity>) repositoryProductsInvoice.findAll();
    }
    
}
