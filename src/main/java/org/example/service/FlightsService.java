package org.example.service;

import org.example.model.dto.FlightsDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public interface  FlightsService {

    void createFlights(FlightsDto flightsDto); //create reservation
    Collection <FlightsDto> getAllFlight();
    Collection <FlightsDto> getAllFlightByOrigin(String origin);
    Collection <FlightsDto> getAllFlightByDestination( String destination);
    Collection <FlightsDto> getAllFlightByFlightId( long id);
    Optional<FlightsDto> getOneFlightByFlightId(long id);
    Collection<FlightsDto> flightsInNext24Hours( String origin, LocalDateTime dateTime);















}
