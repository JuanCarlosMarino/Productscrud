/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.services;

import com.JuanMarino.Productscrud.models.InvoiceEntity;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface InvoiceService {
    public InvoiceEntity save(InvoiceEntity product);
    public void delete(Integer id);
    public InvoiceEntity findById(Integer id);
    public List<InvoiceEntity> findAll();
}
