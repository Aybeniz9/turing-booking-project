package org.example.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.FlightsDao;
import org.example.model.BookingEntity;
import org.example.model.FlightsEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FlightsFileDao  extends FlightsDao {
    private  static  final  String RESOURCE_PATH="src/main/java/org/example/resource";
    private  static final  String FLIGHTS_FILE_PATH=RESOURCE_PATH.concat("flights.txt");
    private final ObjectMapper objectMapper;

    public FlightsFileDao(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override

    public boolean save(List<FlightsEntity> flights) {
        try {
            final Path path= Paths.get(FLIGHTS_FILE_PATH);
            Files.write(path,objectMapper.writeValueAsBytes(flights));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
