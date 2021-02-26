package com.example.examplemodule4.service.impl;

import com.example.examplemodule4.model.Country;
import com.example.examplemodule4.repository.CountryRepository;
import com.example.examplemodule4.service.itf.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountrynServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Page<Country> findAllByName(Pageable pageable, String name) {
        return null;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
