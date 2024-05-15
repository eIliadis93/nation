package com.qualco.nation.service.impl;

import com.qualco.nation.model.Country;
import com.qualco.nation.repository.CountryRepository;
import com.qualco.nation.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Object[]> getAllCountryInfo() {
        return countryRepository.findAllCountryInfo();
    }
}
