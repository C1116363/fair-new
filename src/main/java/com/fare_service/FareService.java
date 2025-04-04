package com.fare_service;



public interface FareService {
    Fare getFareByFlightNumber(String flightNumber);
    Fare saveFare(Fare fare);
}
