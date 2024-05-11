package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.exception.BookingNotFoundException;
import org.example.model.dto.BookingDto;
import org.example.model.dto.FlightsDto;
import org.example.service.BookingService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceİmpl implements BookingService {
    public BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(Collection<BookingDto> bookings) {
        Collection<BookingEntity> bookingDaoAll=bookingDao.getAll();
    }

    @Override
    public void cancelBooking(long id) {
        Collection<BookingEntity> allReservation=bookingDao.getAll();
        Collection<>

    }

    @Override
    public Collection<BookingDto> getAllBookings() {
        return null;
    }

    @Override
    public Collection<BookingDto> getMyFlights(long flightId, String passengerNames) {
        Collection<BookingEntity> bookingDaoAll = bookingDao.getAll();
        Collection<BookingEntity> mybooking = bookingDaoAll.stream().filter(bookingEntity -> bookingEntity.getFlightId() == flightId && bookingEntity.getPassengerName().equals(passengerNames)).toList();
        return mybooking.stream().map(bookingEntity -> new BookingDto(bookingEntity.getId(), bookingEntity.getFlightId(), bookingEntity.getPassengerName())).toList();
    }

    @Override
    public BookingDto findBookingByOne(long id) {
        return null;
    }
}