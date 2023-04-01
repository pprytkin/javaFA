package com.prytkin.flights.controllers;

import com.prytkin.flights.models.Route;
import com.prytkin.flights.repositories.CitiesRepository;
import com.prytkin.flights.services.RouteService;
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
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("")
    public List<Route> getAllRoute() {
        return routeService.getAllRoute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getCitiesById(@PathVariable Long id) {
        try{
            Route cities = routeService.getRouteById(id);
            return new ResponseEntity<Route>(cities, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void addCities(@RequestBody Route cities){
        routeService.saveRoute(cities);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCities(@RequestBody Route cities, @PathVariable Long id){
//        try{
//            Route baseCities = routeService.getRouteById(id);
//            baseCities.updateR(cities);
//            citiesService.saveCities(baseCities);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    public void deleteCities(@PathVariable Long id){
        routeService.deleteRoute(id);
    }
}
