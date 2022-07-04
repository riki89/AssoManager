package com.asso.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Activity {
     @Id
     @GeneratedValue
     private int id;
    private LocalDate date;
    private String lieu;
}