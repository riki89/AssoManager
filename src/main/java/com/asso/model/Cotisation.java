package com.asso.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @Min(0)
    @Max(12)
    private int month;
    @NotNull
    @Min(0)
    private double amount;
    @NotNull
    private LocalDate date;
    //OM, Wave, Cash, ...
    @NotNull
    private String meanOfPayment;
    //Les mois payes (exemple: Jan, Fev, Mars, ...
    private String description;
    @ManyToOne
    private Member member;
}
