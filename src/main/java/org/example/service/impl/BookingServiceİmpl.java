package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.util.Collection;
import java.util.stream.Collectors;

public class BookingServiceİmpl implements BookingService {
    public BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(Collection<BookingDto> bookings) {
        bookingDao.save(bookings.stream()
                .map(dto -> new BookingEntity(dto.getFlightId(), dto.getPassengerName()))
                .collect(Collectors.toList()));
    }

    @Override
    public void cancelBooking(long flightId, long passengerId) {
        bookingDao.delete(flightId, passengerId);
    }

    @Override
    public Collection<BookingDto> getAllBookings() {
        return bookingDao.getAll().stream()
                .map(booking -> new BookingDto(booking.getPassengerId(), booking.getFlightId(), booking.getPassengerName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<BookingDto> getMyFlights(long flightId, String passengerNames) {
        Collection<BookingEntity> bookingDaoAll = bookingDao.getAll();
        Collection<BookingEntity> mybooking = bookingDaoAll.stream().filter(bookingEntity -> bookingEntity.getFlightId() == flightId && bookingEntity.getPassengerName().equals(passengerNames)).toList();
        return mybooking.stream().map(bookingEntity -> new BookingDto(bookingEntity.getPassengerId(), bookingEntity.getFlightId(), bookingEntity.getPassengerName())).toList();
    }
}