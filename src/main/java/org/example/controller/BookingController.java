package org.example.controller;

import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

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


    public void searchBookFlight() {
        // Implement search and book flight logic here
    }

    public void createBooking(Collection<BookingDto> bookingDto) {
        bookingService.createBooking(bookingDto);
    }
    public BookingDto findBookingByOne(long id){
        return bookingService.findBookingByOne(id);
    }

}