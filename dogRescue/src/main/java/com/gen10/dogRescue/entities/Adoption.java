/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
//import java.sql.Date;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author sakim
 */
@Data
@Entity
public class Adoption {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
    @NotBlank(message = "name cannot be empty")
    private String name;

    @Column
    @Email
    private String email;

    @Column
   // @NotNull
    private String phone;

    @Column
  //  @NotBlank(message = "street1 cannot be empty")
    private String street1;

    @Column
    private String street2;

    @Column
  //  @NotBlank(message = "city cannot be empty")
    private String city;

    @Column
   // @NotNull
    private int zipcode;

    @Column
   // @NotNull
    private BigDecimal purchaseprice;

    @ManyToOne
    @JoinColumn(name = "paymenttypeid", nullable = false)
    @JsonBackReference
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "stateid", nullable = false)
    @JsonBackReference
    private State state;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonManagedReference
    private User user;
    
    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "dogid", nullable = false)
    private Dog dog;
    
    @Column
    private Date date;
}
