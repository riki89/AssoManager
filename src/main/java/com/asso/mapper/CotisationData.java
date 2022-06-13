package com.asso.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CotisationData implements Serializable {
    private Integer id;
    private int month;
    private double amount;
    private LocalDate date;
    private String meanOfPayment;
    private String description;
    private int member;
}
