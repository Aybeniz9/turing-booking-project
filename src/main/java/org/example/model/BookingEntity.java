package org.example.model;

import java.util.Objects;

public class BookingEntity {
    private String name;
    private String surname;
    private int id;
    private int flight_id;

    public BookingEntity(String name, String surname, int id, int flight_id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.flight_id = flight_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return id == that.id && flight_id == that.flight_id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, flight_id);
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", flight_id=" + flight_id +
                '}';
    }
}
