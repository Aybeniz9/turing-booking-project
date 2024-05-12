package org.example.service;

import org.example.model.dto.BookingDto;

import java.util.Collection;

public interface BookingService {
    void createBooking(BookingDto bookings);

    void cancelBooking(long passengerId);

    Collection<BookingDto> getAllBookings();

    Collection<BookingDto> getMyFlights(long flightId, String passengerNames);

    BookingDto findBookingByOne(long id);
}
