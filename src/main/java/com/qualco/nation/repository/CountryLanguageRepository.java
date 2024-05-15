package com.qualco.nation.repository;

import com.qualco.nation.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Long> {
    List<CountryLanguage> findByCountry_CountryCode2(String countryCode2);
}
