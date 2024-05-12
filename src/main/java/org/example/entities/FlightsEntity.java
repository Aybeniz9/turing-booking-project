package org.example.entities;

import org.example.model.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.Objects;


public class FlightsEntity {
    public static long MAX_ID = 1;
    private long id;
    private int freeSpaces;
    private LocalDateTime dateTime;
    private String destination;
    private String origin;

    public FlightsEntity() {
    }

    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination, String origin) {
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
        this.origin = origin;
        this.id = MAX_ID++;
    }

    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination, String origin, long flightId) {
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
        this.origin = origin;
        this.id = flightId;
    }

    public FlightsEntity(LocalDateTime dateTime, int freeSpaces, String destination) {
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
        this.id = MAX_ID++;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }


    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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
