package com.fare_service.services;

import com.fare_service.model.Fare;

public interface FareService {
    Fare getFareByFlightNumber(String flightNumber);
    Fare saveFare(Fare fare);
}
