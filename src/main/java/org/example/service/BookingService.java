package org.example.service;

import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;

import java.util.Collection;
import java.util.function.Predicate;

public interface BookingService {
    void createBooking(Collection<BookingDto> bookings);

    void cancelBooking(long flightId,long passengerId);

    Collection<BookingDto> getAllBookings();

    Collection<BookingDto> getMyFlights(long flightId, String passengerNames);
    BookingDto findBookingByOne(long id);

}