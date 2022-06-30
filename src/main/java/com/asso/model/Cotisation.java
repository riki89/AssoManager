package com.asso.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Cotisation {
	@Id
    @GeneratedValue
    private Integer id;
    @Min(0)
    @Max(12)
    private Integer mois;
    @NonNull
    private Double montant;
    @Column
    private LocalDate date;
    @Column
    private String moyenVersement;
    @Column
    private String description;
    
}
