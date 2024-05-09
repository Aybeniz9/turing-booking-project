package org.example.controller;
import org.example.entities.FlightsEntity;
import org.example.exception.BookingNotFoundException;
import org.example.service.BookingService;
import java.util.List;
import java.util.Scanner;



public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void cancelBooking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the booking ID you want to cancel: ");
        String bookingId = scanner.nextLine();

        try {
            bookingService.cancelBooking(bookingId);
            System.out.println("Booking with ID " + bookingId + " has been successfully cancelled.");

        } catch (BookingNotFoundException e) {
            System.out.println("Booking cancellation failed: " + e.getMessage());
        }
    }
    public String getMyFlights(){
       Scanner scanner=new Scanner(System.in);
        System.out.println("Input passenger name");
        String passenger_name= scanner.nextLine();
        return null;
    }

    public void SearchBookFlight(){
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("Enter destination:");
            String destination = scanner.nextLine();

            System.out.printf("Enter date (YYYY-MM-DD):");
            String date = scanner.nextLine();

            System.out.println("Enter number of passengers:");
            int numPassengers = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<FlightsEntity> availableFlights = flightController.searchFlights(destination, date, numPassengers);

            if (availableFlights.isEmpty()) {
                System.out.println("No flights available for the given criteria.");
            } else {
                System.out.println("Available flights:");
                for (int i = 0; i < availableFlights.size(); i++) {
                    FlightsEntity flight = availableFlights.get(i);
                    System.out.println((i + 1) + ". " + flight.toString());
                }

                System.out.println("Enter the serial number of the flight to book (0 to return to main menu):");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 0) {

                } else if (choice > 0 && choice <= availableFlights.size()) {
                    // Book the selected flight
                    Flight selectedFlight = availableFlights.get(choice - 1);
                    System.out.println("Enter passenger names (comma-separated):");
                    String passengerNamesInput = scanner.nextLine();
                    String[] passengerNames = passengerNamesInput.split(",");
                    boolean booked = bookingController.bookFlight(selectedFlight.getId(), passengerNames);
                    if (booked) {
                        System.out.println("Flight booked successfully!");
                    } else {
                        System.out.println("Failed to book the flight. Please try again.");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public String creatBooking(){
        return null;
    }

}
