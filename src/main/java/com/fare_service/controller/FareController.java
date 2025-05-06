package com.fare_service.controller;

import org.springframework.web.bind.annotation.*;

import com.fare_service.exception.FareNotFoundException;
import com.fare_service.model.Fare;
import com.fare_service.repository.FareRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fares")
@Tag(name = "Fare API", description = "Operations related to flight fare data")
public class FareController {

	private static final Logger logger = LoggerFactory.getLogger(FareController.class);
	private final FareRepository fareRepository;

	public FareController(FareRepository fareRepository) {
		this.fareRepository = fareRepository;
	}

	@GetMapping("/{flightNumber}")
	public Fare getFare(@PathVariable String flightNumber) {
		logger.info("Fetching fare for flight number: {}", flightNumber);
		Fare fare = fareRepository.findByFlightNumber(flightNumber);
		if (fare == null) {
			logger.error("Fare not found for flight number: {}", flightNumber);
			throw new FareNotFoundException("Fare not found for flight number: " + flightNumber);
		}
		return fare;
	}

	@PostMapping
	public Fare addFare(@Valid @RequestBody Fare fare) {
		logger.info("Adding new fare: {}", fare);
		return fareRepository.save(fare);
	}
}
