/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.repositories;

import com.gen10.dogRescue.entities.Dog;
import com.gen10.dogRescue.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
    
}
