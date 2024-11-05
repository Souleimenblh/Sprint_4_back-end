package com.souleimen.avions.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.entities.TypeAv;

public interface AvionRepository extends JpaRepository<Avion, Long> {
	
	 List<Avion> findByMatriculeAvion(String nom);
	 List<Avion> findByMatriculeAvionContains(String nom);

		 
		
		@Query("select p from Avion p where p.matriculeAvion like %:matricule and p.celometrageAvion > :celometrage")
		List<Avion> findByMatriculeCelometrage(@Param("matricule") String matricule, @Param("celometrage") int celometrage);
		  
		  
		  @Query("select p from Avion p where p.typeAv = ?1") List<Avion> findByTypeAv
		  (TypeAv typeAv);
		  
		  List<Avion> findByTypeAvIdAv(Long id);
		  
		  List<Avion> findByOrderByMatriculeAvionAsc();
		  
		  @Query("select a from Avion a order by a.matriculeAvion ASC, a.celometrageAvion DESC")
		  List<Avion> trierAvionsMatriculeCelometrage ();
		 

}
