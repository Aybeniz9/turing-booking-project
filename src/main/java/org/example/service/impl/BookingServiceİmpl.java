package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.model.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class BookingServiceİmpl extends BookingDao implements BookingService {
    private final BookingDao bookingDao;
    private List<BookingDto> bookings;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
        this.bookings=new ArrayList<>();
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
            if (booking.equals(bookingDto)){
                return booking;
        }
    }
        return null;
}

    @Override
public BookingDto cancelBooking(BookingDto bookingDto) {
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
    public BookingDto myFlights(BookingDto bookingDto) {
        return null;
    }
}