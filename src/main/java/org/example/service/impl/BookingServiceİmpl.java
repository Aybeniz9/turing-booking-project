package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;
import java.util.*;
import java.util.Iterator;
import java.util.stream.Collectors;

public class BookingServiceİmpl extends BookingDao implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(Collection<BookingDto> bookings) {
    bookingDao.save(bookings.stream().map(dto->new BookingEntity(dto.getFlight_id(),dto.getName())).collect(Collectors.toList()));


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
    public BookingDto myFlights(String bookingDto) {
        return null;
    }
}
