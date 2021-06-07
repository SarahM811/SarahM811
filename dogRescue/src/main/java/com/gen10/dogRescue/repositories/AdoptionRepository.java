/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.repositories;

import com.gen10.dogRescue.entities.Adoption;
import com.gen10.dogRescue.entities.User;
//import java.sql.Date;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {
    
    public List<Adoption> findByUser(User user);
    
    public List<Adoption> findByDateBetween(Date fromDate, Date toDate);
    
}
