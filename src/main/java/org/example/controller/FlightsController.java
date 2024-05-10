package org.example.controller;

import org.example.entities.BookingEntity;
import org.example.entities.FlightsEntity;
import org.example.service.FlightsService;

import java.util.Scanner;

import java.util.*;

public class FlightsController {
    Scanner scanner = new Scanner(System.in);

    private final FlightsService flightsService;

    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;

    }

    public void showTheFlightInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the flight ID:");
        String flight_id = scanner.nextLine();
        FlightsEntity flight = flightsService.getFlightById(flight_id);

        if (flight != null) {
            System.out.println("Flight Information:");
            System.out.println("Date: " + flight.getDateTime());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Available Seats: " + flight.getFreeSpaces());
        } else {
            System.out.println("Flight not found.");
        }
    }

    public String searchBookFlight() {
        return null;
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
                System.out.println("Departure Time: " + flight.getDateTime());
                System.out.println("Available Seats: " + flight.getFreeSpaces());

            }
        }


    }


}
