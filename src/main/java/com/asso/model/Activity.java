package com.asso.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
     @Id
     @GeneratedValue
     private int id;
     private String type;
     @JsonFormat(pattern = "dd/MM/yyyy")
     private LocalDate date;
     private String lieu;
}