package org.example.model.dto;
import java.util.List;

public class BookingDto {
    private static long MAX_ID=0;
    public List<String> name;
    public String surname;
    public Long id;
    public int flight_id;

    public BookingDto() {this.id=++MAX_ID;
    }

    public BookingDto(List<String> name, String surname, long id, int flight_id) {
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

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
}
