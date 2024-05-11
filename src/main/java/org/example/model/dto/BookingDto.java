package org.example.model.dto;

import java.util.List;
import java.util.Objects;

public class BookingDto {
    public static  long MAX_ID = 0;
    private long id;
    private long flightId;
    private String passengerName;

    public BookingDto() {
    }

    public BookingDto(long flightId, String passengerName) {
        this.id = ++MAX_ID;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public BookingDto(long id, long flightId, String passengerName) {
        this.id = id;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return id == that.id && flightId == that.flightId && Objects.equals(passengerName, that.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, passengerName);
    }

    @Override
    public String toString() {
        return "BookingDto{id=%d, flightId=%d, passengerName=%s}".formatted(id, flightId, passengerName);
    }
}
