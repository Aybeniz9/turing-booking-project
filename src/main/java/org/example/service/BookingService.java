package org.example.service;

import org.example.model.dto.BookingDto;

import java.util.Collection;

public interface BookingService {
    void createBooking(Collection<BookingDto> bookings);

    void cancelBooking(long id);

    Collection<BookingDto> getAllBookings();

    Collection<BookingDto> getMyFlights(long flightId, String passengerNames);

    BookingDto findBookingByOne(long id);
}