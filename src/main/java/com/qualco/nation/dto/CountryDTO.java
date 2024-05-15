package com.qualco.nation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private String name;
    private Double area;
    private String country_code2;

}

