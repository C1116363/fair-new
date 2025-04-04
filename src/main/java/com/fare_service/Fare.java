package com.fare_service;




import jakarta.persistence.*;

@Entity
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private double price;

    // Constructors
    public Fare() {}
    public Fare(String flightNumber, double price) {
        this.flightNumber = flightNumber;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}


