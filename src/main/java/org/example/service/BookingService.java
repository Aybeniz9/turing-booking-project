package org.example.service;

import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;

import java.util.*;

public interface BookingService {

    List<BookingEntity> getMyBookings(String passengerFullName);
    boolean bookFlight(String flightId, List<String> passengerNames);


    BookingDto createBooking(BookingDto bookingDto);

    BookingDto searchBooking(BookingDto bookingDto);

    BookingDto cancelBooking(String id);



}
