package org.example;

import org.example.controller.BookingController;
import org.example.controller.FlightsController;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.awt.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import java.util.*;
import java.util.Scanner;


public class BookingManagmentApp {
    Scanner scanner = new Scanner(System.in);
    private final FlightsController flightController;
    private final BookingController bookingController;

    public BookingManagmentApp(FlightsController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Online-board");
            System.out.println("2. Show flight info");
            System.out.println("3. Search and book a flight");
            System.out.println("4. Cancel booking");
            System.out.println("5. My flights");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayOnlineBoard();

                    break;
                case 2:
                    showTheFlightInfo();
                    break;
                case 3:
                    searchBookFlight();
                    break;
                case 4:

                    cancelBooking();
                    break;
                case 5:
                    displayMyFlights();

                    break;
                case 0:
                    //exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayOnlineBoard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the location : ");
        String location = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        Collection<FlightsDto> flights = flightController.getOnlineBoard(location, dateTime);
        for (FlightsDto flight : flights) {
            System.out.println(flight.getId() + " - " + flight.getDestination() + " - " +
                    flight.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public void showTheFlightInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the flight id");
        long id = sc.nextLong();
        Collection<FlightsDto> flights = flightController.getAllFlightsByFLightId(id);
        System.out.println(" Flights Info: ");
        if (flights != null) {
            for (FlightsDto f : flights) {
                System.out.println(f.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "- " + f.getDestination() + " -" + f.getFreeSpaces());

            }
        } else {
            System.out.println(" FLights not found");
        }
    }

    public void searchBookFlight() {


    }

    public void cancelBooking() {

    }


}

