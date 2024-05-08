package org.example.controller;

import org.example.service.BookingService;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public String cancelBooking(){
        bookingService.cancelBooking();
        return null;
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
