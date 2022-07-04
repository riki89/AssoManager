package com.asso.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
//    @Digits(integer = 9, fraction = 0, message = "Phone number should have exactly 10 characters")
    private String phoneNumber;
    private String sex;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate joinDate;
    private boolean memberCard;

    @OneToMany
    List<Cotisation> cotisationList = new ArrayList<>();

    @Override
    public String toString() {
        return lastName+" "+ firstName;
    }

    public double cotisationTotale() {
        double montantTotal = 0;
        for(Cotisation c : cotisationList ) { montantTotal += c.getAmount(); }
        return montantTotal;
    }
}