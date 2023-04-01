package com.prytkin.flights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prytkin.flights.models.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}