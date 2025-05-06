package com.fare_service.services.impl;

import org.springframework.stereotype.Service;

import com.fare_service.model.Fare;
import com.fare_service.repository.FareRepository;
import com.fare_service.services.FareService;

@Service
public class FareServiceImpl implements FareService {

    private final FareRepository fareRepository;

    public FareServiceImpl(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    @Override
    public Fare getFareByFlightNumber(String flightNumber) {
    	
        return fareRepository.findByFlightNumber(flightNumber);
    }

    @Override
    public Fare saveFare(Fare fare) {
        return fareRepository.save(fare);
    }
}
