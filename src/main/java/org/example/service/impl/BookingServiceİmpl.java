package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.entities.BookingEntity;
import org.example.entities.FlightsEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class BookingServiceİmpl extends BookingDao implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
        this.bookings = new ArrayList<>();
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
    public BookingDto<FlightsEntity> searchFlights(String destination, LocalDate date, int numPassengers) {
        // Retrieve all flights from DAO
        List<Flight> allFlights = FlightsFileDao.getAllFlights();

        List<Flight> availableFlights = allFlights.stream()
                .filter(flight -> flight.getDestination().equalsIgnoreCase(destination) &&
                        flight.getDate().isEqual(date) &&
                        flight.getAvailableSeats() >= numPassengers)
                .collect(Collectors.toList());

        return availableFlights;
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
    public BookingDto myFlights(String bookingDto) {
        return null;
    }
}