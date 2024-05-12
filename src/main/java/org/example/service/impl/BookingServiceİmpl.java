package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceİmpl implements BookingService {
    public BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(BookingDto bookingDto) {
        List<BookingEntity> listForSave = new ArrayList<>();
        listForSave.add(new BookingEntity(bookingDto.getFlightId(), bookingDto.getPassengerName()));
        bookingDao.save(listForSave);
    }

    @Override
    public void cancelBooking(long passengerId) {
        bookingDao.delete(passengerId);
    }

    @Override
    public Collection<BookingDto> getAllBookings() {
        return bookingDao.getAll().stream()
                .map(booking -> new BookingDto(booking.getPassengerId(), booking.getFlightId(), booking.getPassengerName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<BookingDto> getMyFlights(long flightId, String passengerNames) {
        Collection<BookingEntity> entities = bookingDao.findAllBy(bookingEntity -> bookingEntity.getFlightId() == flightId &&
                bookingEntity.getPassengerName().equals(passengerNames)).get();
        return entities.stream().map(bookingEntity -> new BookingDto(bookingEntity.getPassengerId(),
                bookingEntity.getFlightId(), bookingEntity.getPassengerName())).toList();
    }


    @Override
    public BookingDto findBookingByOne(long id) {
        return bookingDao.getAll().stream().filter(bookingEntity -> bookingEntity.getPassengerId() == id).findFirst().map(bookingEntity -> new BookingDto(bookingEntity.getPassengerId(), bookingEntity.getFlightId(), bookingEntity.getPassengerName())).get();
    }
}