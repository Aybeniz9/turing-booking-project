package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.entities.FlightsEntity;
import org.example.model.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingServiceİmpl extends BookingDao implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
        this.bookings = new ArrayList<>();
    }


    @Override
    public List<BookingEntity> getMyBookings(String passengerFullName) {
        List<BookingEntity> myBookings = new ArrayList<>();
        List<BookingEntity> allBookings = bookingDao.getAllBookings();

        for (BookingEntity booking : allBookings) {
            if (booking.getName().equalsIgnoreCase(passengerFullName)) {
                myBookings.add(booking);
            }
        }
        return myBookings;
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        BookingEntity bookingEntity = new BookingEntity(
                bookingDto.name,
                bookingDto.surname,
                bookingDto.flight_id,
                (int) (Math.random() * 10000)
        );
        BookingEntity savedEntity = bookingDao.save(bookingEntity);
        return new BookingDto(
                savedEntity.getName(),
                savedEntity.getSurname(),
                savedEntity.getId(),
                savedEntity.getFlight_id()
        );
    }

    @Override
    public BookingDto searchBooking(BookingDto bookingDto) {
        for (BookingDto booking : bookings) {
            if (booking.equals(bookingDto)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public BookingDto cancelBooking(String bookingDto) {
        Iterator<BookingDto> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            BookingDto booking = iterator.next();
            if (booking.equals(bookingDto)) {
                iterator.remove();
                return booking;
            }
        }
        return null;
    }
    @Override
    public boolean bookFlight(String flightId, List<String> passengerNames) {
        FlightsEntity flight = bookingDao.getFlightById(flightId);
        if (flight == null) {
            return false;
        }

        if (flight.getFreeSpaces()< passengerNames.size()) {
            return false;
        }

        // Reduce available seats
        flight.setFreeSpaces(flight.getFreeSpaces()- passengerNames.size());

        // Create booking for each passenger
        for (String passengerName : passengerNames) {
            BookingEntity booking = new BookingEntity(booking.getId(),passengerName);
            flight.getBookings().add(booking);
        }

        // Update flight in the database
        flightsDao.updateFlight(flight);

        return true;
    }


//    @Override
//    public BookingDto myFlights(String bookingDto) {
//        return null;
//    }



}