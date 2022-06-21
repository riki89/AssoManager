package com.asso.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Cotisation {
	@Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer mois;
    @Column
    private Double montant;
    @Column
    private LocalDate date;
    @Column
    private String moyenVersement;
    @Column
    private String description;
    
}
