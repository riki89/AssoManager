package com.asso.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @Size(min = 2, max = 10)
    private String meanOfPayment;
    @Size(min=5, max = 10)
    private String description;
    private int member;
}
