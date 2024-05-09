package org.example.model.dto;

public class BookingDto {
    public String name;
    public String surname;
    public String id;
    public int flight_id;

    public BookingDto() {
    }

    public BookingDto(String name, String surname, String id, int flight_id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", flight_id=" + flight_id +
                '}';
    }
}
