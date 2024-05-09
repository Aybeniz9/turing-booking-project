package org.example.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.FlightsDao;
import org.example.entities.FlightsEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;

public class FlightsFileDao extends FlightsDao {
    private static final String RESOURCE_PATH = "src/main/java/org/example/resource";
    private static final String FLIGHTS_FILE_PATH = RESOURCE_PATH.concat("flights.txt");
    private final ObjectMapper objectMapper;


    public FlightsFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }


    @Override

    public void save(List<FlightsEntity> flights) {
        try {
            final Path path = Paths.get(FLIGHTS_FILE_PATH);
            Files.write(path, objectMapper.writeValueAsBytes(flights));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Iterator<FlightsEntity> iterator = getAllFLights().iterator();
        while (iterator.hasNext()) {
            FlightsEntity flight = iterator.next();
            if (flight.getId().equals(id)) {
                iterator.remove();
                System.out.println("Flight with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Flight with ID " + id + " not found.");
    }

    private String filePath;

    public FlightsFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<FlightsEntity> getAllFLights() {
        List<FlightsEntity> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String destination = parts[1];
                LocalDateTime dateTime = LocalDateTime.parse(parts[2]);
                int freeSeats = Integer.parseInt(parts[3]);
                FlightsEntity flight = new FlightsEntity(id, dateTime, freeSeats, destination);
                flights.add(flight);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }

}
