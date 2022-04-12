package com.elvin.crmapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
    
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String birthdate;
}
