package org.example.entities;

import java.util.Objects;

public class BookingEntity {
    private String name;
    private String surname;
    private String id;
    private int flight_id;

    public BookingEntity() {
    }

    public BookingEntity(String name, String surname, String id, int flight_id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.flight_id = flight_id;
    }

    public BookingEntity(String name, String id, int flight_id) {
        this.name = name;
        this.id = id;
        this.flight_id = flight_id;
    }

    public BookingEntity(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public BookingEntity(String name, int flight_id) {
        this.name = name;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return Objects.equals(id, that.id) && flight_id == that.flight_id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
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
