/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.services;

import com.JuanMarino.Productscrud.models.TypeProductEntity;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TypeProductService {
    public TypeProductEntity save(TypeProductEntity typeProduct);
    public void delete(Integer id);
    public TypeProductEntity findById(Integer id);
    public List<TypeProductEntity> findAll();
}
