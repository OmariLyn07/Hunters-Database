package com.company.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HunterDetails {
    private Long huntingID;
    private String name;
    private Integer rank;
    private Double rating;
    private Locale locale;
}
