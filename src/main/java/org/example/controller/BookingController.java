package org.example.controller;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;
import org.example.service.FlightsService;
import java.util.List;


public class BookingController {
    private final BookingService bookingService;
    private FlightsService flightsService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void delete() {

    }

    public String getMyFlights() {
        return null;
    }

    public void searchBookFlight() {
    }

    public void creatBooking(String passengerName, String flightId, int numberOfTickets) {
    }

    public void save(List <BookingDto> bookingDtos){
        bookingService.createBooking(bookingDtos);
    }
}
