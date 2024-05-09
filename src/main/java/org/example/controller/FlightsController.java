package org.example.controller;

import org.example.entities.FlightsEntity;
import org.example.service.FlightsService;

import java.util.*;

public class FlightsController  {

    private final FlightsService flightsService;
    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }


    public  void displayOnlineBoard(){
            List<FlightsEntity> flights = flightsService.getAllFlightsFromKievNext24Hours();

            System.out.println("Flights from Kiev in the next 24 hours:");
            System.out.println("--------------------------------------");
            if (flights.isEmpty()) {
                System.out.println("No flights available from Kiev in the next 24 hours.");
            } else {
                for (FlightsEntity flight : flights) {
                    System.out.println(flight); // Assuming Flight class has appropriate toString() method
                }
            }
    }
    public String searchBookFlight(){
        return null;
    }
    public String showTheFlightInfo(){
        return null;
    }


}
