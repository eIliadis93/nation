package com.qualco.nation.service.impl;

import com.qualco.nation.dto.LanguageDTO;
import com.qualco.nation.model.CountryLanguage;
import com.qualco.nation.repository.CountryLanguageRepository;
import com.qualco.nation.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryLanguageServiceImpl implements CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public CountryLanguageServiceImpl(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }


    @Override
    public List<CountryLanguage> getLanguagesByCountryId(int countryId) {
        return List.of();
    }

    @Override
    public List<LanguageDTO> getLanguagesByCountryCode2(String country_code2) {
        List<CountryLanguage> countryLanguages = countryLanguageRepository.findByCountry_CountryCode2(country_code2);
        return countryLanguages.stream()
                .map(countryLanguage -> {
                    LanguageDTO languageDTO = new LanguageDTO();
                    languageDTO.setLanguage(countryLanguage.getLanguage().getLanguage());
                    return languageDTO;
                })
                .collect(Collectors.toList());
    }

}
