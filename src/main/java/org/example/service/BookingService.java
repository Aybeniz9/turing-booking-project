package org.example.service;

import org.example.model.dto.BookingDto;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);

    BookingDto searchBooking(BookingDto bookingDto);

    BookingDto cancelBooking(BookingDto id);

    BookingDto myFlights(BookingDto bookingDto);

}
