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
        Iterator<FlightsEntity> iterator = getAllFlights().iterator();
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
    @Override
    public void updateFlight(FlightsEntity updatedFlight) {
        List<FlightsEntity> flights = getAllFlights();
        for (int i = 0; i < flights.size(); i++) {
            FlightsEntity flight = flights.get(i);
            if (flight.getId().equals(updatedFlight.getId())) {
                flights.set(i, updatedFlight);
                break;
            }
        }
        writeFlightsToFile(flights);
    }
    private void writeFlightsToFile(List<FlightsEntity> flights) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (FlightsEntity flight : flights) {
                writer.write(flight.getId() + "," + flight.getDestination() + "," + flight.getDateTime() + "," + flight.getFreeSpaces());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String filePath;

    public FlightsFileDao(ObjectMapper objectMapper, String filePath) {
        this.objectMapper = objectMapper;
        this.filePath = filePath;
    }
    @Override
    public List<FlightsEntity> getAllFlights() {
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
    @Override
    public FlightsEntity getFlightById(String id) {
        List<FlightsEntity> flights = getAllFlights();
        for (FlightsEntity flight : flights) {
            if (flight.getId().equals(id)) {
                return flight;
            }
        }
        return null;
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
        return getAll().stream().filter(predicate).findFirst();
    }

    @Override
    public Collection<FlightsEntity> findAllBy(Predicate<FlightsEntity> predicate) {
        return getAll().stream().filter(predicate).toList();
    }

}


//    @Override
//    public List<FlightsEntity> getAllFLights() {
//        List<FlightsEntity> flights = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                String id = parts[0];
//                String destination = parts[1];
//                LocalDateTime dateTime = LocalDateTime.parse(parts[2]);
//                int freeSeats = Integer.parseInt(parts[3]);
//                FlightsEntity flight = new FlightsEntity(id, dateTime, freeSeats, destination);
//                flights.add(flight);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return flights;
//    }