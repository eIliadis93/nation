package com.qualco.nation.controller;

import com.qualco.nation.dto.ContinentRegionCountryDTO;
import com.qualco.nation.service.ContinentRegionCountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContinentRegionCountryController {

    private final ContinentRegionCountryService continentRegionCountryService;

    public ContinentRegionCountryController(ContinentRegionCountryService continentRegionCountryService) {
        this.continentRegionCountryService = continentRegionCountryService;
    }


}

