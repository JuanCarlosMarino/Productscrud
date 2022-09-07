/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.services.impl;

import com.JuanMarino.Productscrud.dao.InvoiceDao;
import com.JuanMarino.Productscrud.models.InvoiceEntity;
import com.JuanMarino.Productscrud.services.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class InvoiceServiceImp implements InvoiceService{
    
    @Autowired
    private InvoiceDao repositoryInvoice;

    @Override
    @Transactional(readOnly = false)
    public InvoiceEntity save(InvoiceEntity invoice) {
        return repositoryInvoice.save(invoice);
    }

    @Override
    public void delete(Integer id) {
        repositoryInvoice.deleteById(id);
    }

    @Override
    public InvoiceEntity findById(Integer id) {
        return repositoryInvoice.findById(id).orElse(null);
    }

    @Override
    public List<InvoiceEntity> findAll() {
        return(List<InvoiceEntity>) repositoryInvoice.findAll();
    }
    
}
