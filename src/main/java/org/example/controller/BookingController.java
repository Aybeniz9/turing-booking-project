package org.example.controller;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;
import org.example.service.FlightsService;

import java.io.IOException;
import java.util.List;


public class BookingController {
    private final BookingService bookingService;
    private FlightsService flightsService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void delete() {

    }

    public String getMyFlights(long flightId,String names) {
        return String.valueOf(bookingService.getMyFlights( flightId,names));
    }

    public void searchBookFlight() {
    }

    public void creatBooking(BookingDto bookingDto)throws IOException {
        bookingService.createBooking();
    }

    public void save(List <BookingDto> bookingDtos){
        bookingService.createBooking(bookingDtos);
    }
}
