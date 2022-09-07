
package com.JuanMarino.Productscrud.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idProduct;
    
    @Column(name = "nombreproducto")
    private String productName;
    
    @Column(name = "valorcompra")
    private double purchaseValue;
    
    @Column(name = "valorventa")
    private double saleValue;
    
    @Column(name = "cantidad")
    private double amount;
    
    @ManyToOne
    @JoinColumn(name = "idtipoproducto")
    private TypeProductEntity idTypeProduct;

    public Integer getIdProduct() {
        return idProduct;
    }    

    public TypeProductEntity getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(TypeProductEntity idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
