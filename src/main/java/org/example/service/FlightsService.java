package org.example.service;

import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.util.*;

public interface  FlightsService {
    List<FlightsEntity> getAllFlightsFromKievNext24Hours();
    FlightsDto onlineBoard( FlightsDto flightsDto);
    FlightsDto String searchBookFlight(FlightsDto flightsDto);
    List<FlightsEntity> getFlightsFromKievNext24Hours();
    FlightsEntity getFlightById(String flightId);
    List<FlightsEntity> searchFlights(String destination, String date, int numPeople);

}
