package com.prytkin.flights.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prytkin.flights.models.Cities;
import com.prytkin.flights.repositories.CitiesRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CitiesService {
    @Autowired
    private CitiesRepository citiesRepository;


    public List<Cities> getAllCities(){
        return citiesRepository.findAll();
    }

    public Cities getCitiesById(Long id){
        return citiesRepository.findById(id).get();
    }

    public void saveCities(Cities cities){
        citiesRepository.save(cities);
    }

    public void deleteCities(Long id){
        citiesRepository.deleteById(id);
    }
}
