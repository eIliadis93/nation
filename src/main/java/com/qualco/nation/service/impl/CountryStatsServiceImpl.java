package com.qualco.nation.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualco.nation.dto.CountryRegionContinentDTO;
import com.qualco.nation.dto.CountryStatsDTO;
import com.qualco.nation.model.CountryStats;
import com.qualco.nation.repository.CountryStatsRepository;
import com.qualco.nation.service.CountryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryStatsServiceImpl implements CountryStatsService {

    @Autowired
    private CountryStatsRepository countryStatsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<CountryStatsDTO> findMaxGdpPerPopulationStats() {
        List<CountryStats> countryStatsList = countryStatsRepository.findMaxGdpPerPopulationStats();
        return countryStatsList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CountryStatsDTO mapToDTO(CountryStats countryStats) {
        CountryStatsDTO dto = new CountryStatsDTO();
        dto.setCountryId(countryStats.getId().getCountryId());
        dto.setCountry(objectMapper.convertValue(countryStats.getCountry(), Object.class));
        dto.setYear(countryStats.getId().getYear());
        dto.setPopulation(countryStats.getPopulation());
        dto.setGdp(countryStats.getGdp());
        return dto;
    }

    @Override
    public List<CountryRegionContinentDTO> findCountryRegionContinentInfo() {
        return this.countryStatsRepository.findCountryRegionContinentInfo();
    }
}
