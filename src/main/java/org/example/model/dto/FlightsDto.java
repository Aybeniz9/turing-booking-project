package org.example.model.dto;

import java.time.LocalDateTime;

public class FlightsDto {
    public String id;
    public LocalDateTime dateTime;
    public int freeSpaces;
    public String destination;


    public FlightsDto(String id, LocalDateTime dateTime, int freeSpaces, String destination) {
        this.id = id;
        this.dateTime = dateTime;
        this.freeSpaces = freeSpaces;
        this.destination = destination;
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
