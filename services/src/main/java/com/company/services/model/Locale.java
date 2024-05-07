package com.company.services.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locale")
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String terrain;
    private String name;
    private String mon_types;
}
