package org.example.service;

import org.example.dao.FlightsDao;
import org.example.model.FlightsEntity;
import org.example.model.dto.FlightsDto;

import java.awt.*;

public interface  FlightsService {
    FlightsDto onlineBoard( FlightsDto flightsDto);
    FlightsDto String searchBookFlight(FlightsDto flightsDto);

    List<FlightsEntity> getFlightsFromKievNext24Hours();
    FlightsEntity getFlightById(String flightId);
    List<FlightsEntity> searchFlights(String destination, String date, int numPeople);

}
