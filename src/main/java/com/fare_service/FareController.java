package com.fare_service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fares")
public class FareController {
    private final FareRepository fareRepository;

    public FareController(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    @GetMapping("/fare/{flightNumber}")
    public Fare getFare(@PathVariable String flightNumber) {
        return fareRepository.findByFlightNumber(flightNumber);

    }

    @PostMapping
    public Fare addFare(@RequestBody Fare fare) {
        return fareRepository.save(fare);
    }
}
