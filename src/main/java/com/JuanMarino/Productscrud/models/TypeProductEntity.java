
package com.JuanMarino.Productscrud.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoproducto")
public class TypeProductEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipoproducto")
    private Integer idTypeProduct;
    
    @Column(name = "nombre")
    private String typeProductName;

    public Integer getIdTypeProduct() {
        return idTypeProduct;
    }    

    public String getTypeProductName() {
        return typeProductName;
    }

    public void setTypeProductName(String typeProductName) {
        this.typeProductName = typeProductName;
    }
    


   
    
}
