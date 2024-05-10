package org.example.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class BookingFileDao extends BookingDao {

    private static final String RESOURCE_PATH = "src/main/java/org/example/resource/";
    private static final String BOOKINGS_FILE_PATH = RESOURCE_PATH + "bookings.json";
    private final ObjectMapper objectMapper;

    public BookingFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    @Override
    public void save(List<BookingEntity> bookings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKINGS_FILE_PATH))) {
            bw.write(objectMapper.writeValueAsString(bookings));
        } catch (IOException e) {
            System.out.println("Error save bookings" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        getAll().remove(id);
    }

    @Override
    public Collection<BookingEntity> getAll() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(BOOKINGS_FILE_PATH))) {
            return new ArrayList<>(Arrays.asList(objectMapper.readValue(bufferedReader, BookingEntity.class)));
        } catch (IOException e) {
            System.err.println("Error reading bookins from file" + e.getMessage());
            return Collections.emptyList();
        }

    }

    @Override
    public Optional<BookingEntity> findOneBy(Predicate<BookingEntity> predicate) {
        Optional<BookingEntity> first = getAll().stream().filter(predicate).findFirst();
        return first;
    }

    @Override
    public Collection<BookingEntity> findAllBy(Predicate<BookingEntity> predicate) {
        Collection<BookingEntity> first = getAll().stream().filter(predicate).findFirst().stream().toList();
        return first;
    }
}