/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JuanMarino.Productscrud.services.impl;

import com.JuanMarino.Productscrud.dao.UserDao;
import com.JuanMarino.Productscrud.models.UserEntity;
import com.JuanMarino.Productscrud.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class UserServiceImp implements UserService{
    
    @Autowired
    private UserDao repositoryUser;

    @Override
    @Transactional(readOnly = false)
    public UserEntity save(UserEntity product) {
        return repositoryUser.save(product);
    }

    @Override
    public void delete(Integer id) {
        repositoryUser.deleteById(id);
    }

    @Override
    public UserEntity findById(Integer id) {
        return repositoryUser.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return(List<UserEntity>) repositoryUser.findAll();
    }
    
}
