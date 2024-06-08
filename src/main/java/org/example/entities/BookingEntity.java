package org.example.entities;

import java.util.Objects;

public class BookingEntity {

    public static long MAX_ID = 0;
    private long passengerId;
    private long flightId;
    private String passengerName;

    public BookingEntity() {
    }

    public BookingEntity(long flightId, String passengerName) {
        this.passengerId = ++MAX_ID;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }
    public BookingEntity(long passengerId, long flightId, String passengerName) {
        this.passengerId = passengerId;
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
        BookingEntity that = (BookingEntity) o;
        return passengerId == that.passengerId && flightId ==
                that.flightId && Objects.equals(passengerName, that.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, flightId, passengerName);
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "passengerId=" + passengerId +
                ", flightId=" + flightId +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }
}
