package com.qualco.nation.dto;

import lombok.Data;

@Data
public class ContinentRegionCountryDTO {
    private String continentName;
    private String regionName;
    private String countryName;
    private int year;
    private int population;
    private long gdp;

}

