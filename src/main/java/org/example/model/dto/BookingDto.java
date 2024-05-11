package org.example.model.dto;

import java.util.Objects;

public class BookingDto {
    public static  long MAX_ID = 0;
    private long passengerId;
    private long flightId;
    private String passengerName;

    public BookingDto() {
    }

    public BookingDto(long flightId, String passengerName) {
        this.passengerId = ++MAX_ID;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public BookingDto(long id, long flightId, String passengerName) {
        this.passengerId = id;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
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
        BookingDto that = (BookingDto) o;
        return passengerId == that.passengerId && flightId == that.flightId && Objects.equals(passengerName, that.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, flightId, passengerName);
    }

    @Override
    public String toString() {
        return "BookingDto{id=%d, flightId=%d, passengerName=%s}".formatted(passengerId, flightId, passengerName);
    }
}
