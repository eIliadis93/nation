package com.qualco.nation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryStatsDTO {
    private Long countryId;
    private Object country;
    private int year;
    private int population;
    private double gdp;
}
