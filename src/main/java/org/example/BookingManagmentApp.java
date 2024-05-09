package org.example;

import org.example.controller.BookingController;
import org.example.controller.FlightsController;
import org.example.entities.FlightsEntity;


import java.util.*;
import java.util.Scanner;


public class BookingManagmentApp {


    public class Console {
        private final Scanner scanner;
        private final FlightsController flightController;
        private final BookingController bookingController;

        public Console() {
            scanner = new Scanner(System.in);
            flightController = new FlightsController();
            bookingController = new BookingController();
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
                        flightController.displayOnlineBoard();

                        break;
                    case 2:
                        flightController.showTheFlightInfo();
                        break;
                    case 3:
                        bookingController.searchBookFlight();
                        break;
                    case 4:

                        bookingController.cancelBooking();
                        break;
                    case 5:
                        bookingController.displayMyFlights();

                        break;
                    case 0:
                        exit();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

//        private static void displayOnlineBoard() {
//            System.out.println("Online Board: Flights from Kiev in the next 24 hours");
//            System.out.println("-----------------------------------------------------");
//
//            // Get the list of flights from Kiev in the next 24 hours from the FlightManager
//            List<FlightsEntity> flights = flightsController.getFlightsFromKievInNext24Hours();
//
//            if (flights.isEmpty()) {
//                System.out.println("No flights available in the next 24 hours.");
//            } else {
//                System.out.printf("%-15s %-20s %-25s\n", "Flight Number", "Destination", "Departure Time");
//                System.out.println("------------------------------------------------------------");
//                for (FlightsEntity flight : flights) {
//                    System.out.printf("%-15s %-20s %-25s\n", flight.getId(), flight.getDestination(), flight.getDate());
//                }
//            }
//            displayMainMenu();

        }


    }
}
