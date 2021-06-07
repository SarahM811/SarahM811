/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author sakim
 */
@Data
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
//    @NotBlank
    private String firstname;

    @Column
//    @NotBlank
    private String lastname;

    @Column
//    @NotBlank
    private String email;
    
//    @ManyToMany
//    @JoinTable(name = "role_user",
//            joinColumns = {@JoinColumn(name = "userid")},
//            inverseJoinColumns = {@JoinColumn(name = "roleid")})
//    private List<Role> roles;
    
    @Column
//    @NotBlank
    private boolean active;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "roleid", nullable = false)
    private Role role;
    
    @Column
    private String password;
}
