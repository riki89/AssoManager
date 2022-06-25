package com.asso.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String meanOfPayment;
    private String description;
    private int member;
}
