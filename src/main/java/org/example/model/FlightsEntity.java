package org.example.model;
import java.time.LocalDateTime;
import java.util.Objects;


public class FlightsEntity {
    private String id;
    private LocalDateTime dateTime;
    private int freeSpaces;
    private String destination;

    public FlightsEntity() {
    }

    public FlightsEntity(String id, LocalDateTime date, int freeSpaces, String destination) {
        this.id = id;
        this.dateTime = date;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public void setDate(LocalDateTime date) {
        this.dateTime = date;
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
        if (o == null || getClass() != o.getClass()) return false;
        FlightsEntity that = (FlightsEntity) o;
        return freeSpaces == that.freeSpaces && Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, freeSpaces, destination);
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "id='" + id + '\'' +
                ", date=" + dateTime +
                ", freeSpaces=" + freeSpaces +
                ", destination='" + destination + '\'' +
                '}';
    }
}
