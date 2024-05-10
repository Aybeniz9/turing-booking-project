package org.example.service;

import org.example.model.dto.BookingDto;

import java.util.Collection;

public interface BookingService {
    void createBooking(Collection<BookingDto> bookingDto);

    BookingDto searchBooking(BookingDto bookingDto);

    void cancelBooking(int id);

    BookingDto myFlights(String bookingDto);

}
