/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.repositories;

import com.gen10.dogRescue.entities.Adoption;
import com.gen10.dogRescue.entities.Dog;
import com.gen10.dogRescue.entities.LifeStage;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sakim
 */
@Repository
public interface DogRepository extends JpaRepository<Dog, Integer>{
    
    public List<Dog> findByLifeStage(LifeStage lifeStage);
    
    //public List<Dog> findByAdoption(Adoption adoption);
    
//    @Query("select d from Dog as d inner join d.breed as b on d.breedid = b.id where (d.name like '%?1%') or (b.name like '%?1%')")
//    public List<Dog> findByNameOrBreedContaining(String name);
    
    public List<Dog> findByFeaturedTrue();
    
    
//    public List<Dog> findByNameLike(String name);
    
   @Query("select d from Dog d where d.breed.Name LIKE %:userinput%")
   public List<Dog> findByBreedContainingIgnorecase(@Param("userinput") String userinput);
   
    @Query("select d from Dog d where d.name LIKE %:userinput%")
   public List<Dog> findByNameContainingIgnorecase(@Param("userinput") String userinput);

//    @Query("select Dog from Dog where breed like'%?1'")
//    public List<Dog> findListByBreedSearch(String breed);
}
