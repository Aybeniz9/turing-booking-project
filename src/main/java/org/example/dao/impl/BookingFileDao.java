package org.example.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class BookingFileDao extends BookingDao {

    private static final String RESOURCE_PATH = "D:\\turing-booking-project-1\\src\\main\\java\\org\\example\\resource\\";
    private static final String BOOKINGS_FILE_PATH = RESOURCE_PATH + "bookings.json";
    private final ObjectMapper objectMapper;

    public BookingFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }


    @Override
    public void save(List<BookingEntity> bookings) {
        try {
            FileWriter fw = new FileWriter(BOOKINGS_FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objectMapper.writeValueAsString(bookings));
            bw.close();
        } catch (IOException e) {
            System.err.println("Error while adding new flight: " + e.getMessage());
        }
    }


    @Override
    public Collection<BookingEntity> getAll() {
        try {
            FileReader fr = new FileReader(BOOKINGS_FILE_PATH);
            BufferedReader x = new BufferedReader(fr);
            String jsonData = x.readLine();
            if (jsonData != null && !jsonData.isBlank()) {
                BookingEntity[] bookings = objectMapper.readValue(jsonData, BookingEntity[].class);
                x.close();
                var tempList = Arrays.asList(bookings);
                return new ArrayList<>(tempList);
            }
            x.close();
        } catch (IOException e) {
            System.out.println("Error while reading flights from file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public void delete(long passengerId) {
        Collection<BookingEntity> bookingForCancel = getAll();
        bookingForCancel.removeIf(bookingEntity -> bookingEntity.getPassengerId() == passengerId);
        save((List<BookingEntity>) bookingForCancel);

    }
    @Override
    public Optional<BookingEntity> findOneBy(Predicate<BookingEntity> predicate) {
        return getAll().stream().filter(predicate).findFirst();
    }

    @Override
    public Optional<Collection<BookingEntity>> findAllBy(Predicate<BookingEntity> predicate) {
        return Optional.of(getAll().stream().filter(predicate).findFirst().stream().toList());
    }
}