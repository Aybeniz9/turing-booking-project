package org.example.entities;

import org.example.model.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.Objects;


public class FlightsEntity {
    public static long MAX_ID = 1;
    private long id;
    private LocalDateTime dateTime;
    private int freeSpaces;
    private String destination;
    private String origin;

//    public FlightsEntity() {
//        private int passengerNumber;
//    }

    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination, String origin) {
        this.id = MAX_ID++;
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
        this.origin = origin;
    }


//    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination) {
//        this.dateTime = dateTime;
//        this.freeSpaces = freeSpaces;
//        this.destination = destination;
//    }

    public FlightsEntity(LocalDateTime dateTime) {
        this.id = MAX_ID++;
        this.dateTime = dateTime;
    }

    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination) {
        this.id = MAX_ID++;
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
    }


    public FlightsEntity( LocalDateTime dateTime, int freeSpaces) {
        this.id = MAX_ID;
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
    }

    public FlightsEntity(int freeSpaces, String destination) {
        this.id = MAX_ID;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
    }

//
//    public FlightsEntity(Long id, LocalDateTime dateTime, int freeSpaces, String destination, String origin, int passengerNumber) {
//        this.id = id;
//        this.dateTime = dateTime;
//        this.freeSpaces = freeSpaces;
//        this.destination = destination;
//        this.origin = origin;
//        this.passengerNumber = passengerNumber;
//    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getPassengerNumber() {
//        return passengerNumber;
//    }
//
//    public void setPassengerNumber(int passengerNumber) {
//        this.passengerNumber = passengerNumber;
//    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightsDto that)) return false;
        return getFreeSpaces() == that.getFreeSpaces() && Objects.equals(getId(), that.getId()) && Objects.equals(getDateTime(), that.getDateTime()) && Objects.equals(getDestination(), that.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateTime(), getFreeSpaces(), getDestination());
    }

    @Override
    public String toString() {
        return "FlightsDto{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", freeSpaces=" + freeSpaces +
                ", destination='" + destination + '\'' +
                '}';
    }
}
