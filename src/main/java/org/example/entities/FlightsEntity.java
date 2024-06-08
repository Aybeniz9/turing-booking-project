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

    public FlightsEntity(long id, int freeSpaces, LocalDateTime dateTime, String destination, String origin) {
        this.id = id;
        this.freeSpaces = freeSpaces;
        this.dateTime = dateTime;
        this.destination = destination;
        this.origin = origin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsEntity that = (FlightsEntity) o;
        return id == that.id && freeSpaces == that.freeSpaces && Objects.equals(dateTime, that.dateTime) && Objects.equals(destination, that.destination) && Objects.equals(origin, that.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, freeSpaces, dateTime, destination, origin);
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "id=" + id +
                ", freeSpaces=" + freeSpaces +
                ", dateTime=" + dateTime +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
