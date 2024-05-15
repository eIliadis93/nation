package com.qualco.nation.repository;

import com.qualco.nation.dto.CountryRegionContinentDTO;
import com.qualco.nation.model.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryStatsRepository extends JpaRepository<CountryStats, Integer> {

    List<CountryStats> findAll();

    @Query("SELECT cs FROM CountryStats cs JOIN FETCH cs.country WHERE cs.gdp / cs.population = (SELECT MAX(cs2.gdp / cs2.population) FROM CountryStats cs2 WHERE cs2.country.countryId = cs.country.countryId)")
    List<CountryStats> findMaxGdpPerPopulationStats();

    @Query("SELECT new com.qualco.nation.dto.CountryRegionContinentDTO(c.region.continent.name, c.region.name, c.name, cs.id.year, cs.population, cs.gdp) " +
            "FROM CountryStats cs " +
            "JOIN cs.country c " +
            "JOIN c.region r " +
            "JOIN r.continent ct")
    List<CountryRegionContinentDTO> findCountryRegionContinentInfo();
}
