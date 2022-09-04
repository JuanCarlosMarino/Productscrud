/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.services.impl;

import com.JuanMarino.Productscrud.dao.ProductDao;
import com.JuanMarino.Productscrud.models.ProductEntity;
import com.JuanMarino.Productscrud.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ProductServiceImp implements ProductService{
    
    @Autowired
    private ProductDao repositoryProduct;

    @Override
    @Transactional(readOnly = false)
    public ProductEntity save(ProductEntity product) {
        return repositoryProduct.save(product);
    }

    @Override
    public void delete(Integer id) {
        repositoryProduct.deleteById(id);
    }

    @Override
    public ProductEntity findById(Integer id) {
        return repositoryProduct.findById(id).orElse(null);
    }

    @Override
    public List<ProductEntity> findAll() {
        return(List<ProductEntity>) repositoryProduct.findAll();
    }
    
}
