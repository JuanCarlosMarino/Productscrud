/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.dao;

import com.JuanMarino.Productscrud.models.TypeProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface TypeProductDao extends CrudRepository<TypeProductEntity, Integer>{
    
}
