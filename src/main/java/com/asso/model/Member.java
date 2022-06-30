package com.asso.model;

import lombok.*;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
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
    private String phoneNumber;
    private String sex;
    //bureau_member or simple_member
    private String type;
    private String function;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate joinDate;
    private boolean memberCard;
    
   // private List<RegleGroupe> regleGroups = new ArrayList<RegleGroupe>();
    //private List<Activity> activities = new ArrayList<Activity>();
    private List<Cotisation> cotisations = new ArrayList<Cotisation>();

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