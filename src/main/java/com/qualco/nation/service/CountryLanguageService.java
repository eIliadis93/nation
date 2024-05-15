package com.qualco.nation.service;

import com.qualco.nation.dto.LanguageDTO;
import com.qualco.nation.model.CountryLanguage;

import java.util.List;

public interface CountryLanguageService {
    List<CountryLanguage> getLanguagesByCountryId(int countryId);

    List<LanguageDTO> getLanguagesByCountryCode2(String country_code2);
}
