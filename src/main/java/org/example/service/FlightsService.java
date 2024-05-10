package org.example.service;

import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public interface  FlightsService {

    boolean save(Collection<FlightsDto> flightsEntities); //create reservation
    void delete (int flight_id);
    Collection<FlightsDto> findAllFlight();
    Optional<FlightsDto> findFlightId(Predicate<FlightsDto> predicate);
    Collection <FlightsDto> getAllFlight();







}
