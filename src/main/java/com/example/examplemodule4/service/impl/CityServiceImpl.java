package com.example.examplemodule4.service.impl;

import com.example.examplemodule4.model.City;
import com.example.examplemodule4.repository.CityRepository;
import com.example.examplemodule4.service.itf.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Page<City> findAllByName(Pageable pageable, String name) {
        return cityRepository.findAllByNameContaining(pageable, name);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

}
