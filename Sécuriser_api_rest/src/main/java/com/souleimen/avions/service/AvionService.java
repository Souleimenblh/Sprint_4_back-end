package com.souleimen.avions.service;

import java.util.List;
import com.souleimen.avions.entities.Avion;
import com.souleimen.avions.entities.TypeAv;

public interface AvionService {
	Avion saveAvion(Avion a);
	Avion updateAvion(Avion a);
	void deleteAvion(Avion a);
	void deleteAvionById(Long id);
	Avion getAvion(Long id);
	List<Avion> getAllAvions();



	List<Avion> findByMatriculeAvion(String matriculeAvion);
	List<Avion> findByMatriculeAvionContains(String matriculeAvion);
	List<Avion> findByfindByMatriculeCelometrage (String matriculeAvion, int celometrageAvion);
	List<Avion> findByTypeAv (TypeAv typeAv);
	List<Avion> findByTypeAvIdA(Long id);
	List<Avion> findByOrderByMatriculeAvAsc();
	List<Avion> trierAvionsMatriculeCelometrage();



}