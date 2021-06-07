/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 *
 * @author sakim
 */
@Entity
@Data
public class Contact {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
    @NotBlank(message = "name cannot be empty")
    private String name;

    @Column
    @Email
    private String email;

//    @Column
//    @NotNull(message="phone number needs to be entered")
//    private int phone;
    @Column
    //@Pattern(regexp = "^$|^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "Please enter a valid phone number")
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[\\s.-]?(\\d{3})[\\s.-]?(\\d{4})$", message = "Please enter a valid phone number")
   // @Pattern(regexp="(^$|[0-9]{10})", message = "Please enter a valid phone number")
    private String phone;

    @Column(name = "message")
    private String message;

    @Column
    private String dogname;
}
