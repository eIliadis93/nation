package com.qualco.nation.service.impl;

import com.qualco.nation.model.Continent;
import com.qualco.nation.repository.ContinentRepository;
import com.qualco.nation.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;

    @Autowired
    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }
}
