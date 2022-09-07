/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.services.impl;

import com.JuanMarino.Productscrud.dao.TypeProductDao;
import com.JuanMarino.Productscrud.models.TypeProductEntity;
import com.JuanMarino.Productscrud.services.TypeProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class TypeProductServiceImp implements TypeProductService{
    
    @Autowired
    private TypeProductDao repositoryTypeProduct;

    @Override
    @Transactional(readOnly = false)
    public TypeProductEntity save(TypeProductEntity product) {
        return repositoryTypeProduct.save(product);
    }

    @Override
    public void delete(Integer id) {
        repositoryTypeProduct.deleteById(id);
    }

    @Override
    public TypeProductEntity findById(Integer id) {
        return repositoryTypeProduct.findById(id).orElse(null);
    }

    @Override
    public List<TypeProductEntity> findAll() {
        return(List<TypeProductEntity>) repositoryTypeProduct.findAll();
    }
    
}
