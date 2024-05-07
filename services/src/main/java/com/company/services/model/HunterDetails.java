package com.company.services.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HunterDetails {
    private Long huntingID;
    private String fName;
    private String lName;
    private String address;
    private Blacksmith blacksmith;
}
