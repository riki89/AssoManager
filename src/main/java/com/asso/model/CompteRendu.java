package com.asso.model;

import javax.persistence.*;


import lombok.Data;
@Entity
@Data

public class CompteRendu {
    @Id
    @GeneratedValue
    private Integer id;
    private String ordreJ;
    private String resume;
    
    
    
}
