package org.example.controller;

import org.example.exception.BookingNotFoundException;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

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
    public String myFlights(){
        return null;
    }
    public String SearchBookFlight(){
        return null;
    }
    public String creatBooking(){
        return null;
    }

}
