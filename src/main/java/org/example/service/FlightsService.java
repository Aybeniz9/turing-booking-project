package org.example.service;

import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.*;

public interface  FlightsService {
//    FlightsEntity getFlightById(String flight_id);
//    List<FlightsEntity> searchAvailableFlights(String destination, LocalDateTime dateTime);
    boolean save(Collection<FlightsDto> flightsEntities);
    Collection <FlightsDto> getAllFlight();




}
