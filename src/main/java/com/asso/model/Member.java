package com.asso.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private Integer id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String sex;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate joinDate;
    private boolean memberCard;

    @Override
    public String toString() {
        return lastName+" "+ firstName;
    }
}