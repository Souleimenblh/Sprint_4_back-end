package com.souleimen.avions.entities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class TypeAv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAv;
    private String matriculeAv;
    private String infoAv;

    @OneToMany(mappedBy = "typeAv")
    @JsonIgnore
    private List<Avion> avions;

 
}