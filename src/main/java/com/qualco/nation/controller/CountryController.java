package com.qualco.nation.controller;

import com.qualco.nation.dto.CountryDTO;
import com.qualco.nation.dto.LanguageDTO;
import com.qualco.nation.model.Country;
import com.qualco.nation.model.Region;
import com.qualco.nation.service.CountryLanguageService;
import com.qualco.nation.service.CountryService;
import com.qualco.nation.service.impl.CountryLanguageServiceImpl;
import com.qualco.nation.service.impl.CountryServiceImpl;
import com.qualco.nation.service.impl.RegionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryServiceImpl countryServiceImpl;
    private final CountryLanguageService countryLanguageServiceImpl;
    private final RegionServiceImpl regionServiceImpl;

    public CountryController(CountryService countryService, CountryLanguageService countryLanguageService, CountryServiceImpl countryServiceImpl, CountryLanguageServiceImpl countryLanguageServiceImpl, RegionServiceImpl regionServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
        this.countryLanguageServiceImpl = countryLanguageServiceImpl;
        this.regionServiceImpl = regionServiceImpl;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to the Nation API!");
    }


    @GetMapping("/countries/info")
    public ResponseEntity<List<Country>> getAllCountryInfo() {
        List<Country> countries = countryServiceImpl.getAllCountries(); // Assuming this method exists
        return ResponseEntity.ok(countries);
    }


    private CountryDTO mapToCountryDTO(Object[] data) {
        String name = (String) data[1];
        Double value = Double.parseDouble((String) data[2]);
        String description = (String) data[3];
        return new CountryDTO(name, value, description);
    }




    @GetMapping("/countries/{country_code2}/languages")
    public ResponseEntity<List<String>> getLanguagesByCountryCode2(@PathVariable String country_code2) {
        List<LanguageDTO> languages = countryLanguageServiceImpl.getLanguagesByCountryCode2(country_code2);
        List<String> languageNames = new ArrayList<>();
        for (LanguageDTO language : languages) {
            languageNames.add(language.getLanguage());
        }
        return ResponseEntity.ok(languageNames);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regions = regionServiceImpl.getAllRegions();
        return ResponseEntity.ok(regions);
    }
}
