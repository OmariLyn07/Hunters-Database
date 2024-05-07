package com.company.services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hunter")
@Data
public class Hunter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long huntingID;
    private String name;
    private Integer rank;
    private Double rating;

    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Locale locale;
}
