package com.qualco.nation.service;

import com.qualco.nation.dto.CountryRegionContinentDTO;
import com.qualco.nation.dto.CountryStatsDTO;

import java.util.List;

public interface CountryStatsService {

    List<CountryRegionContinentDTO> findCountryRegionContinentInfo();
}
