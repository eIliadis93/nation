package com.qualco.nation.service.impl;

import com.qualco.nation.dto.ContinentRegionCountryDTO;
import com.qualco.nation.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentRegionCountryServiceImpl implements ContinentRegionCountryService {

    private final ContinentService continentService;
    private final RegionService regionService;
    private final CountryService countryService;
    private final CountryStatsService countryStatsService;

    public ContinentRegionCountryServiceImpl(ContinentService continentService, RegionService regionService,
                                             CountryService countryService, CountryStatsService countryStatsService) {
        this.continentService = continentService;
        this.regionService = regionService;
        this.countryService = countryService;
        this.countryStatsService = countryStatsService;
    }

}

