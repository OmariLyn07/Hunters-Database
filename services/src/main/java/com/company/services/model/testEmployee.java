package com.company.services.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "test_employee")
public class testEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fname;
    private String lname;
    private Integer salary;
    //Add other relevant fields and annotations as needed

}
