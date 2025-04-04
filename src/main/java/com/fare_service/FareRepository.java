package com.fare_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Long> {
    Fare findByFlightNumber(String flightNumber);
}

