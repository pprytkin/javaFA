package com.prytkin.flights.services;

import java.util.List;

import com.prytkin.flights.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prytkin.flights.models.Route;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;


    public List<Route> getAllRoute(){
        return routeRepository.findAll();
    }

    public Route getRouteById(Long id){
        return routeRepository.findById(id).get();
    }

    public void saveRoute(Route route){
        routeRepository.save(route);
    }

    public void deleteRoute(Long id){
        routeRepository.deleteById(id);
    }
}
