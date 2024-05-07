package com.company.services.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blacksmith")
public class Blacksmith {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Long id;
    private String location;
}
