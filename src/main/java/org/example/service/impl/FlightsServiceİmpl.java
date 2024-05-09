package org.example.service.impl;

import org.example.dao.FlightsDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;

import java.time.LocalDateTime;
import java.util.*;

public class FlightsServiceİmpl implements FlightsService {
    private final FlightsDao flightsDao;

    public FlightsServiceİmpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }
    private FlightsFileDao flightsFileDAO;

    public List<FlightsEntity> getAllFlightsFromKievNext24Hours() {
        List<FlightsEntity> allFlights = flightsFileDAO.getAllFlights();
        List<FlightsEntity> flightsFromKievNext24Hours = new ArrayList<>();

        // Assuming Flight class has appropriate methods to check origin and departure time
        for (FlightsEntity flight : allFlights) {
            if (flight.getOrigin().equalsIgnoreCase("Kiev") && isWithinNext24Hours(flight.getDate())) {
                flightsFromKievNext24Hours.add(flight);
            }
        }

        return flightsFromKievNext24Hours;
    }

    private boolean isWithinNext24Hours(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24Hours = now.plusHours(24);
        return dateTime.isAfter(now) && dateTime.isBefore(next24Hours);
    }







    @Override
    public FlightsDto onlineBoard(FlightsDto flightsDto) {
        return null;
    }

    @Override
    public String searchBookFlight(FlightsDto flightsDto) {
        return null;
    }

    @Override
    public List<FlightsEntity> getFlightsFromKievNext24Hours() {
        return flightsDao.getFlightsFromKievNext24Hours(); // Delegate to DAO
    }

    @Override
    public FlightsEntity getFlightById(String flightId) {
        return flightsDao.getFlightById(flightId); // Delegate to DAO
    }

    @Override
    public List<FlightsEntity> searchFlights(String destination, String date, int numPeople) {
        return flightsDao.searchFlights(destination, date, numPeople); // Delegate to DAO
    }
}
}
