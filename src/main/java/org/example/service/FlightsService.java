package org.example.service;

import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.util.*;

public interface  FlightsService {
    List<FlightsEntity> getAllFlightsFromKievNext24Hours();
    FlightsEntity getFlightById(String flight_id);
    List<FlightsEntity> searchAvailableFlights(String destination, String date, int numPassengers);

    List<FlightsEntity> getMyFlights(String name);
    FlightsDto displayOnlineBoard( FlightsDto flightsDto);
    //FlightsDto String searchBookFlight(FlightsDto flightsDto);

    List<FlightsEntity> searchFlights(String destination, String date, int numPeople);

}
