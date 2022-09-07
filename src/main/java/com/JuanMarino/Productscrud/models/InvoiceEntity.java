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
@Table(name = "factura")
public class InvoiceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private Integer idInvoice;

    @Column(name = "fecha")
    private String date;

    @Column(name = "clave")
    private double password;
    
    @ManyToOne
    @JoinColumn(name = "idusuarios")
    private UserEntity iDUsers;

}
