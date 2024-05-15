package com.qualco.nation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryRegionContinentDTO {

    private String continentName;
    private String regionName;
    private String countryName;
    private int year;
    private long population;
    private double gdp;
}
