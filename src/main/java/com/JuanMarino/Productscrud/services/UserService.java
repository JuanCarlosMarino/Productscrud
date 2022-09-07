/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JuanMarino.Productscrud.services;

import com.JuanMarino.Productscrud.models.UserEntity;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UserService {
    public UserEntity save(UserEntity user);
    public void delete(Integer id);
    public UserEntity findById(Integer id);
    public List<UserEntity> findAll();
}
