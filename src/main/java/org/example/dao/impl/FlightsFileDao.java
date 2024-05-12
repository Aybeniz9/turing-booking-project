package org.example.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.FlightsDao;
import org.example.entities.FlightsEntity;

import java.io.*;
import java.util.List;
import java.util.*;
import java.util.function.Predicate;

public class FlightsFileDao extends FlightsDao {
    private static final String RESOURCE_PATH = "C:\\Users\\User\\IdeaProjects\\Turing\\java-course-turing\\turing-booking-project-1\\src\\main\\java\\org\\example\\resource\\";
    private static final String FLIGHTS_FILE_PATH = RESOURCE_PATH.concat("flight.json");
    private final ObjectMapper objectMapper;

    public FlightsFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

    @Override
    public void save(List<FlightsEntity> bookings) {
        try {
            FileWriter fw = new FileWriter(FLIGHTS_FILE_PATH);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objectMapper.writeValueAsString(bookings));
            bw.close();
        } catch (IOException e) {
            System.err.println("Error while adding new flight: " + e.getMessage());
        }
    }


    @Override
    public Collection<FlightsEntity> getAll() {
        try {
            FileReader fr = new FileReader(FLIGHTS_FILE_PATH);
            BufferedReader x = new BufferedReader(fr);
            String jsonData = x.readLine();
            if (jsonData != null && !jsonData.isBlank()) {
                FlightsEntity[] bookings = objectMapper.readValue(jsonData, FlightsEntity[].class);
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
    public Optional<FlightsEntity> findOneBy(Predicate<FlightsEntity> predicate) {
        Optional<FlightsEntity> first = getAll().stream().filter(predicate).findFirst();
        return first;
    }

    @Override
    public Optional<Collection<FlightsEntity>> findAllBy(Predicate<FlightsEntity> predicate) {
        Collection<FlightsEntity> allBy = getAll().stream().filter(predicate).toList();
        return Optional.of(allBy);
    }

    @Override
    public void delete(long flightId) {

    }
}