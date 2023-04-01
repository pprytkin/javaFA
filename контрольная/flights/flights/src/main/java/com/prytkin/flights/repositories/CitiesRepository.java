package com.prytkin.flights.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prytkin.flights.models.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Long> {
}
