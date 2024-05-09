package org.example.service.impl;
import java.util.*;

import org.example.dao.FlightsDao;
import org.example.model.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;

import java.util.List;

public class FlightsServiceİmpl implements FlightsService {
    private final FlightsDao flightsDao;

    public FlightsServiceİmpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
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
