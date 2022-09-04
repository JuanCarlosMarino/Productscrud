/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.services;

import com.JuanMarino.Productscrud.models.ProductEntity;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProductService {
    public ProductEntity save(ProductEntity product);
    public void delete(Integer id);
    public ProductEntity findById(Integer id);
    public List<ProductEntity> findAll();
}
