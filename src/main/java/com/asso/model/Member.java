package com.asso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String firstName;
    private String tel;
    private String sex;
    @JsonFormat(pattern = "dd/MM/yyyyy")
    private LocalDate dateAdhesion;
    private boolean carteMembre;
}