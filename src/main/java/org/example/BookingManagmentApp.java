package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.BookingController;
import org.example.controller.FlightsController;
import org.example.dao.BookingDao;
import org.example.dao.FlightsDao;
import org.example.dao.impl.BookingFileDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.entities.BookingEntity;
import org.example.entities.FlightsEntity;
import org.example.exception.BookingNotFoundException;
import org.example.exception.FlightNotFoundException;
import org.example.model.dto.BookingDto;
import org.example.model.dto.FlightsDto;
import org.example.service.BookingService;
import org.example.service.FlightsService;
import org.example.service.impl.BookingServiceİmpl;
import org.example.service.impl.FlightsServiceİmpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

public class BookingManagmentApp {
    Scanner scanner = new Scanner(System.in);
    FlightsDao flightsDao = new FlightsFileDao(new ObjectMapper());
    FlightsService flightsService = new FlightsServiceİmpl(flightsDao);
    FlightsController flightsController = new FlightsController(flightsService);
    BookingDao bookingDao = new BookingFileDao(new ObjectMapper());
    BookingService bookingService = new BookingServiceİmpl(bookingDao);
    BookingController bookingController = new BookingController(bookingService);
    LocalDateTime dateTime = LocalDateTime.of(2024, 5, 12, 23, 45, 34);
    LocalDateTime dateTime2 = LocalDateTime.of(2024, 5, 12, 23, 46, 35);
    FlightsEntity flightsEntity = new FlightsEntity(dateTime, 20, "Ispanya", "Cehennem");
    FlightsEntity flightsEntity2 = new FlightsEntity(dateTime2, 30, "Amerika", "Italia");
    BookingEntity bookingEntity1 = new BookingEntity(1, "Ali");
    BookingEntity bookingEntity2 = new BookingEntity(2, "Farid");


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

                    try {
                        System.out.println("Enter booking id: ");
                        int bookingId = scanner.nextInt();
                        bookingController.cancelBooking(bookingId);
                    } catch (InputMismatchException e) {
                        System.out.println("You input is not integer");
                    } catch (BookingNotFoundException e) {
                        System.out.println("Booking not fount ");
                    }
                    break;
                case 5:
                    System.out.print("Please enter your name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your id");
                    long flightId = scanner.nextLong();
                    try {
                        Collection<BookingDto> flights = bookingController.getMyFlights(flightId, name);
                        for (BookingDto flight : flights) {
                            System.out.println(flight);
                        }

                    } catch (InputMismatchException e) {
                        System.out.println(" Id is not integer");
                    } catch (FlightNotFoundException e) {
                        System.out.println("Flight Not find here");
                    }
                    break;
                case 0:
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
        Collection<FlightsDto> flights = flightsController.getOnlineBoard(location, dateTime);
        for (FlightsDto flight : flights) {
            System.out.println(flight.getId() + " - " + flight.getDestination() + " - " +
                    flight.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public void showTheFlightInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the flight id");
        long id = sc.nextLong();
        Collection<FlightsDto> flights = flightsController.getAllFlightsByFLightId(id);
        System.out.println(" Flights Info: ");
        if (flights != null) {
            for (FlightsDto f : flights) {
                System.out.println(f.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "- " + f.getDestination() + " -" + f.getFreeSpaces());

            }
        } else {
            System.out.println(" FLights not found");
        }
    }

    private void searchBookFlight() {
    }

    public void configure() {
        FlightsDto flightsDto1 = new FlightsDto(flightsEntity.getId(), flightsEntity.getDateTime(), flightsEntity.getFreeSpaces(), flightsEntity.getDestination(), flightsEntity.getOrigin());
        FlightsDto flightsDto2 = new FlightsDto(flightsEntity2.getId(), flightsEntity2.getDateTime(), flightsEntity2.getFreeSpaces(), flightsEntity2.getDestination(), flightsEntity2.getOrigin());
        flightsService.createFlights(flightsDto1);
        flightsService.createFlights(flightsDto2);
        BookingDto bookingDto1 = new BookingDto(bookingEntity1.getFlightId(), bookingEntity1.getPassengerName());
        BookingDto bookingDto2 = new BookingDto(bookingEntity2.getFlightId(), bookingEntity2.getPassengerName());
        bookingService.createBooking(bookingDto1);
        bookingService.createBooking(bookingDto2);

    }
}

