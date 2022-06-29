package com.asso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    @Size(min=2,max=20)
    private String lastName;
    @NotNull
    @Size(min=2,max=20)
    private String firstName;
    @NotNull
    @Size(min=2,max=20)
    private String tel;
    private String type;
    
    private String sex;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateAdhesion;
    private boolean carteMembre;
    
   // private List<RegleGroupe> regleGroups = new ArrayList<RegleGroupe>();
    //private List<Activity> activities = new ArrayList<Activity>();
    private List<Cotisation> cotisations = new ArrayList<Cotisation>();
    
    public double cotisationTotale() {
    	double montantTotal = 0;
    	for(Cotisation c : cotisations )
    	{
    		montantTotal += c.getMontant();
    	}
        return montantTotal;
    }
}