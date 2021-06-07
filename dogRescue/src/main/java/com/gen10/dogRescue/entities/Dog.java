/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author sakim
 */
@Data
@Entity
@Table(name = "dog")
public class Dog {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "sizeid", nullable = false)
    @JsonManagedReference
    private Size size;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "breedid", nullable = false)
    @JsonManagedReference
//    @JsonIgnoreProperties({ "user" })
    private Breed breed;
    
//    @Column(insertable=false, updatable=false)
//    private int breedid;

    @Column
//    @NotBlank
    private int age;

    @Column(name = "adoptionprice")
//    @NotBlank
    private BigDecimal adoptionPrice;

    @Column
//    @NotBlank
    private String description;

    @Column
//    @NotBlank
    private String name;

//    @OneToOne
//    @JoinColumn(name = "adoptionid", nullable = true)
//   // @JsonManagedReference
//    @JsonBackReference
//    private Adoption adoption;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "lifestageid", nullable = false)
    //@JsonBackReference
    @JsonManagedReference
    private LifeStage lifeStage;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "trainlevelid", nullable = false)
    private TrainLevel trainLevel;

    @Column(name="featured")
//    @NotNull
    private boolean featured = false;

    @Column(name = "imagepath")
    private String imagepath;
    
    @Column
    private boolean isavailable = true;

}
