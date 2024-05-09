package org.example.dao;

import org.example.entities.BookingEntity;

import java.util.*;

public abstract class BookingDao implements DAO<BookingEntity> {
    private List<BookingEntity> bookings = new ArrayList<>();

    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}