package com.qualco.nation.controller;

import com.qualco.nation.dto.CountryRegionContinentDTO;
import com.qualco.nation.dto.CountryStatsDTO;
import com.qualco.nation.model.Region;
import com.qualco.nation.service.CountryStatsService;
import com.qualco.nation.service.impl.CountryStatsServiceImpl;
import com.qualco.nation.service.impl.RegionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country-stats")
public class CountryStatsController {

    private final CountryStatsServiceImpl countryStatsServiceImpl;
    private final RegionServiceImpl regionServiceImpl;

    @Autowired
    public CountryStatsController(CountryStatsServiceImpl countryStatsServiceImpl, RegionServiceImpl regionServiceImpl) {
        this.countryStatsServiceImpl = countryStatsServiceImpl;
        this.regionServiceImpl = regionServiceImpl;
    }

    @GetMapping("/max-gdp-per-population")
    public List<CountryStatsDTO> getMaxGdpPerPopulationStats() {
        return countryStatsServiceImpl.findMaxGdpPerPopulationStats();
    }

    @GetMapping("/country-region-continent")
    public ResponseEntity<List<CountryRegionContinentDTO>> findCountryRegionContinentInfo() {
        List<CountryRegionContinentDTO> countryRegionContinent = countryStatsServiceImpl.findCountryRegionContinentInfo();
        return ResponseEntity.ok(countryRegionContinent);
    }

}
