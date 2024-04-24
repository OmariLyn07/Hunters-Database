package com.company.services.model;

import jakarta.persistence.*;
import lombok.Data;

//Example department model
@Data
@Entity
@Table(name ="department")
public class testDepartment {
    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq",
            initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dnum; //Start dnum at 100
    private String dname;
}
