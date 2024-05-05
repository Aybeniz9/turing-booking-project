package org.example.service.impl;

import org.example.dao.BookingDao;
import org.example.service.BookingService;

public class BookingServiceİmpl implements BookingService {
    private final BookingDao bookingDao;

    public BookingServiceİmpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }
}

