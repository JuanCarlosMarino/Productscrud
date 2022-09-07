/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.services;

import com.JuanMarino.Productscrud.models.ProductsInvoiceEntity;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProductsInvoiceService {
    public ProductsInvoiceEntity save(ProductsInvoiceEntity product);
    public void delete(Integer id);
    public ProductsInvoiceEntity findById(Integer id);
    public List<ProductsInvoiceEntity> findAll();
}
