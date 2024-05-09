package org.example.controller;

import org.example.entities.FlightsEntity;
import org.example.service.FlightsService;

import java.util.*;

public class FlightsController  {

    private final FlightsService flightsService;
    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }
    public void displayOnlineBoard() {
        List<FlightsEntity> flights = flightsService.getAllFlightsFromKievNext24Hours();

        System.out.println("Online-board:");
        System.out.println("-------------");
        if (flights.isEmpty()) {
            System.out.println("No flights available from Kiev in the next 24 hours.");
        } else {
            for (FlightsEntity flight : flights) {
                System.out.println("Flight ID: " + flight.getId());
                System.out.println("Destination: " + flight.getDestination());
                System.out.println("Departure Time: " + flight.getDate());
                System.out.println("Available Seats: " + flight.getFreeSpaces());
                System.out.println();
            }
        }

    public String searchBookFlight(){
        return null;
    }
    public String showTheFlightInfo(){
        return null;
    }


}
