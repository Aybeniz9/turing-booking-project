package org.example.service;

import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;

import java.util.Collection;
import java.util.List;

public interface BookingService {
    void createBooking(Collection<BookingDto> bookings);

    void cancelBooking(long id);

    Collection<BookingDto> getAllBookings();

    Collection<BookingEntity> getBookFlight(String flightId, List<String> passengerNames);

    BookingDto findBookingByOne(long id);
}