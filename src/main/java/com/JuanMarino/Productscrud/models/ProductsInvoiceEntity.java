
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
@Table(name = "productosfactura")
public class ProductsInvoiceEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproductosfactura")
    private Integer idProductsInvoice;
    
    @Column(name = "cantidad")
    private Integer amount;
    
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductEntity idProduct;
    
    @ManyToOne
    @JoinColumn(name = "idfactura")
    private TypeProductEntity idInvoice;

    public Integer getIdProductsInvoice() {
        return idProductsInvoice;
    }

    public void setIdProductsInvoice(Integer idProductsInvoice) {
        this.idProductsInvoice = idProductsInvoice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ProductEntity getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ProductEntity idProduct) {
        this.idProduct = idProduct;
    }

    public TypeProductEntity getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(TypeProductEntity idInvoice) {
        this.idInvoice = idInvoice;
    }


    
}
