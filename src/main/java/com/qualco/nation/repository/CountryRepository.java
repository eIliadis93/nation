package com.qualco.nation.repository;

import com.qualco.nation.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("SELECT c.name, c.area, c.countryCode2 FROM Country c")
    List<Object[]> findAllCountryInfo();
}
