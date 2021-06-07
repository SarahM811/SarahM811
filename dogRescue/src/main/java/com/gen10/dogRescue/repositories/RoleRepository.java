/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.repositories;

import com.gen10.dogRescue.entities.Role;
import com.gen10.dogRescue.entities.TrainLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
