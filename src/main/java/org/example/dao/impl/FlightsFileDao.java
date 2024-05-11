package org.example.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.FlightsDao;
import org.example.entities.FlightsEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;
import java.util.function.Predicate;

public class FlightsFileDao extends FlightsDao {
    private static final String RESOURCE_PATH = "src/main/java/org/example/resource";
    private static final String FLIGHTS_FILE_PATH = RESOURCE_PATH.concat("flights.json");
    private final ObjectMapper objectMapper;

    public FlightsFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }


    @Override

    public void save(List<FlightsEntity> flightsEntities) {
       try {
           FileWriter fw= new FileWriter(FLIGHTS_FILE_PATH);
           BufferedWriter bf=new BufferedWriter(fw);
           bf.write(objectMapper.writeValueAsString(flightsEntities));
           bf.close();
       }catch (IOException e){
           e.getMessage();
       }
    }

    @Override
    public void delete(long flightId, long passengerId) {

    }
    @Override
    public Collection<FlightsEntity> getAll() {
        try {
            FileReader fr = new FileReader(FLIGHTS_FILE_PATH);
            BufferedReader x = new BufferedReader(fr);
            String jsonData = x.readLine();
            if (jsonData != null && !jsonData.isBlank()) {
                FlightsEntity[] flights = objectMapper.readValue(jsonData, FlightsEntity[].class);
                x.close();
                return Arrays.stream(flights).toList();
            }
            x.close();
        } catch (IOException e) {
            System.out.println("Error while reading flights from file: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<FlightsEntity> findOneBy(Predicate<FlightsEntity> predicate) {
        Optional<FlightsEntity> first = getAll().stream().filter(predicate).findFirst();
        return first;
    }

    @Override
    public Collection<FlightsEntity> findAllBy(Predicate<FlightsEntity> predicate) {
        Collection <FlightsEntity> allBy= getAll().stream().filter(predicate).toList();
        return allBy;
    }
}