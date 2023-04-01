package com.prytkin.flights.controllers;

import com.prytkin.flights.models.Cities;
import com.prytkin.flights.repositories.CitiesRepository;
import com.prytkin.flights.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @GetMapping("")
    public List<Cities> getAllCities() {
        return citiesService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cities> getCitiesById(@PathVariable Long id) {
        try{
            Cities cities = citiesService.getCitiesById(id);
            return new ResponseEntity<Cities>(cities, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Cities>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void addCities(@RequestBody Cities cities){
        citiesService.saveCities(cities);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCities(@RequestBody Cities cities, @PathVariable Long id){
        try{
            Cities baseCities = citiesService.getCitiesById(id);
            baseCities.updateCities(cities);
            citiesService.saveCities(baseCities);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteCities(@PathVariable Long id){
        citiesService.deleteCities(id);
    }
}
