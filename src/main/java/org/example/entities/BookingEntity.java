package org.example.entities;

import java.util.Objects;

public class BookingEntity {
    public static long MAX_ID = 0;
    private long bookingID;
    private long flightId;
    private String passengerName;

    public BookingEntity() {
    }

    public BookingEntity(long flightId, String passengerName) {
        this.bookingID = ++MAX_ID;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }
    public BookingEntity(long bookingID, long flightId, String passengerName) {
        this.bookingID = bookingID;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity booking = (BookingEntity) o;
        return bookingID == booking.bookingID && flightId == booking.flightId && Objects.equals(passengerName, booking.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, flightId, passengerName);
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "passengerId=" + bookingID +
                ", flightId=" + flightId +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }
}
