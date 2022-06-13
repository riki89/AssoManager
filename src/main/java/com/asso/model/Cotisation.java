package com.asso.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cotisation {
    @Id
    @GeneratedValue
    private Integer id;
    private int month;
    private double amount;
    private LocalDate date;
    //OM, Wave, Cash, ...
    private String meanOfPayment;
    //Les mois payes (exemple: Jan, Fev, Mars, ...
    private String description;
    @ManyToOne
    private Member member;
}
