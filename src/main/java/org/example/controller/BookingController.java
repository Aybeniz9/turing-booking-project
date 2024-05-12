package org.example.controller;

import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.util.Collection;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void cancelBooking(long flightId,long passengerId) {
        bookingService.cancelBooking(flightId,passengerId);
    }

    public Collection<BookingDto>getMyFlights(long flightId, String names) {
    return bookingService.getMyFlights(flightId,names);
    }


    public void searchAndBookFlight(BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
    }

    public BookingDto findBookingByOne(long id){
        return bookingService.findBookingByOne(id);
    }

}