package com.souleimen.avions.entities;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvion;
	private String matriculeAvion;
	private int celometrageAvion;
	private Date dateFabrication;
	
	@ManyToOne
	private TypeAv typeAv;
	
	public Avion() {
		super();
	}
	
	public Avion(String matriculeAvion, int celometrageAvion, Date dateFabrication) {
		super();
		this.matriculeAvion = matriculeAvion;
		this.celometrageAvion = celometrageAvion;
		this.dateFabrication = dateFabrication;
	}

	public Long getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}
	public String getMatriculeAvion() {
		return matriculeAvion;
	}
	public void setMatriculeAvion(String matriculeAvion) {
		this.matriculeAvion = matriculeAvion;
	}
	public int getCelometrageAvion() {
		return celometrageAvion;
	}
	public void setCelometrageAvion(int celometrageAvion) {
		this.celometrageAvion = celometrageAvion;
	}
	public Date getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}


	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", matriculeAvion=" + matriculeAvion + ", celometrageAvion="
				+ celometrageAvion + ", dateFabrication=" + dateFabrication + "]";
	}

	public TypeAv getTypeAv() {
		return typeAv;
	}

	public void setTypeAv(TypeAv typeAv) {
		this.typeAv = typeAv;
	}
	
	
	
	
}
